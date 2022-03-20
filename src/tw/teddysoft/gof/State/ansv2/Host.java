package tw.teddysoft.gof.State.ansv2;

public class Host {
	public static final State UP_HARD = new UpHard();
	public static final State UP_SOFT = new UpSoft();
	public static final State DOWN_HARD = new DownHard();
	public static final State DOWN_SOFT = new DownSoft();
	private Command checkCommand;
	private int maxAttempt = 3;
	private int attempt = 0;
	private State currentState = UP_HARD;
	public Host(Command command) {
		checkCommand = command;
	}
	public void setCommand(Command command) {
		checkCommand = command;
	}
	public void check() {
		CheckResult result = checkCommand.execute();
		if (CheckResult.UP == result) 
			currentState.up(this);
		else if (CheckResult.DOWN == result) 
			currentState.down(this);
	}
	public void powerOff() {
		currentState.powerOff(this);
	}
	public void powerOn() {
		currentState.powerOn(this);
	}
	public String diagnostic() {
		return currentState.diagnostic(this);
	}
	public int getAttempt() {
		return attempt;
	}
	public State getState() {
		return currentState;
	}
	public void changeState(State newState) {
		resetAttempt();
		currentState = newState;
	}
	public int getMaxAttempt() {
		return maxAttempt;
	}
	private void resetAttempt() {
		attempt = 1;
	}
	protected void doGracefulPowerOff() {
		System.out.println("Power off gracefully.");
	}
	protected void doPowerOff(int delay) {
		System.out.println("Power off after " + delay + " second(s).");
	}
	protected void doPowerOn() {
		System.out.println("Power On.");
	}
	protected String inBandDiagnostic() {
		return "Diagnostic via the remote agent.";
	}
	protected String outOfBandDiagnostic() {
		return "Diagnostic via IPMI.";
	}
	protected void incAttempt() {
		attempt++;
	}
}
