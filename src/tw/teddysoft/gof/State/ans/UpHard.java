package tw.teddysoft.gof.State.ans;

public class UpHard implements State {
	@Override
	public void powerOff(Host host) {
		host.doGracefulPowerOff();
	}
	@Override
	public void powerOn(Host host) {
		System.out.println("Cannot power on under up hard state.");
	}
	@Override
	public String diagnostic(Host host) {
		return host.inBandDiagnostic();
	}
	@Override
	public void check(Host host, CheckResult result) {
		if (CheckResult.UP == result) {
			host.incAttempt();
		}
		else if (CheckResult.DOWN == result) {
			host.changeState(Host.DOWN_SOFT);
		}
	}
}
