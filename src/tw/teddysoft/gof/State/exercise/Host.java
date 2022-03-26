package tw.teddysoft.gof.State.exercise;

public class Host {
	public static final State UP_HARD = new UpHardState();
	public static final State UP_SOFT = new UpSoftState();
	public static final State DOWN_HARD = new DownHard();
	public static final State DOWN_SOFT = new DownSoft();
	private State currentState = UP_HARD;
	private Command checkCommand;
	private final int maxAttempt = 3;
	private int attempt = 0;
	public Host(Command command) {
		checkCommand = command;
	}
	public void setCommand(Command command) {
		checkCommand = command;
	}
	public void check() {
		CheckResult result = checkCommand.execute();
		currentState.check(this, result);
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
	public void addAttempt() {
		this.attempt++;
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
	public void doGracefulPowerOff() {
		System.out.println("Power off gracefully.");
	}
	public void doPowerOff(int delay) {
		System.out.println("Power off after " + delay + " second(s).");
	}
	public void doPowerOn() {
		System.out.println("Power On.");
	}
	public String inBandDiagnostic() {
		return "Diagnostic via the remote agent.";
	}
	public String outOfBandDiagnostic() {
		return "Diagnostic via IPMI.";
	}
}
