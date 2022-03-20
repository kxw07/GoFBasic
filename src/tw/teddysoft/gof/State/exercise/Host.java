package tw.teddysoft.gof.State.exercise;

public class Host {
	private HostState currentState = HostState.UP_HARD;
	private Command checkCommand;
	private int maxAttempt = 3;
	private int attempt = 0;
	public Host(Command command) {
		checkCommand = command;
	}
	public void setCommand(Command command) {
		checkCommand = command;
	}
	public void check() {
		CheckResult result = checkCommand.execute();
		switch (result){
		case UP:
			switch (currentState){
			case UP_HARD:
				attempt++;
				break;
			case UP_SOFT:
				attempt++;
				if (attempt >=  maxAttempt)
					changeState(HostState.UP_HARD);
				break;
			case DOWN_HARD:
				changeState(HostState.UP_SOFT);
				break;
			case DOWN_SOFT:
				changeState(HostState.UP_HARD);
				break;
			}
			break;
		case DOWN:
			switch (currentState){
			case UP_HARD:
				changeState(HostState.DOWN_SOFT);
				break;
			case UP_SOFT:
				changeState(HostState.DOWN_HARD);
				break;
			case DOWN_HARD:
				attempt++;
				break;
			case DOWN_SOFT:
				attempt++;
				if (attempt >=  maxAttempt) {
					changeState(HostState.DOWN_HARD);
				}
				break;
			}
			break;
		}
	}
	public void powerOff() {
		switch (currentState){
		case UP_HARD:
			doGracefulPowerOff();
			break;
		case UP_SOFT:
			doPowerOff(60);
			break;
		case DOWN_HARD:
			System.out.println("Cannot power off under down hard state.");
			break;
		case DOWN_SOFT:
			System.out.println("Cannot power off under down soft state.");
			break;
		}
	}
	public void powerOn() {
		switch (currentState){
		case UP_HARD:
			System.out.println("Cannot power on under up hard state.");
			break;
		case UP_SOFT:
			System.out.println("Cannot power on under up soft state.");
			break;
		case DOWN_HARD:
			doPowerOn();
			break;
		case DOWN_SOFT:
			System.out.println("Cannot power on under down soft state.");
			break;
		}
	}
	public String diagnostic() {
		switch (currentState){
		case UP_HARD:
			return inBandDiagnostic();
		case UP_SOFT:
			String result = inBandDiagnostic();
			if ("" == result)
				return outOfBandDiagnostic();
			else 
				return result;
		case DOWN_HARD:
			return outOfBandDiagnostic();
		case DOWN_SOFT:
			return outOfBandDiagnostic();
		default:
			throw new RuntimeException
			("Unsupported state: "+ currentState);			
		}
	}
	public int getAttempt() {
		return attempt;
	}
	public HostState getState() {
		return currentState;
	}
	public void changeState(HostState newState) {
		resetAttempt();
		currentState = newState;
	}
	public int getMaxAttempt() {
		return maxAttempt;
	}
	private void resetAttempt() {
		attempt = 1;
	}
	private void doGracefulPowerOff() {
		System.out.println("Power off gracefully.");
	}
	private void doPowerOff(int delay) {
		System.out.println("Power off after " + delay + " second(s).");
	}
	private void doPowerOn() {
		System.out.println("Power On.");
	}
	private String inBandDiagnostic() {
		return "Diagnostic via the remote agent.";
	}
	private String outOfBandDiagnostic() {
		return "Diagnostic via IPMI.";
	}
}
