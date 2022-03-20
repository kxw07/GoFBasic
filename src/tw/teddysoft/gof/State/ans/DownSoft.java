package tw.teddysoft.gof.State.ans;

public class DownSoft implements State {

	@Override
	public void powerOff(Host host) {
		System.out.println("Cannot power off under down soft state.");
	}

	@Override
	public void powerOn(Host host) {
		System.out.println("Cannot power on under down soft state.");
	}

	@Override
	public String diagnostic(Host host) {
		return host.outOfBandDiagnostic();
	}

	@Override
	public void check(Host host, CheckResult result) {
		if (CheckResult.UP == result) {
			host.changeState(Host.UP_HARD);
		}
		else if (CheckResult.DOWN == result) {
			host.incAttempt();
			if (host.getAttempt () >=  host.getMaxAttempt()) {
				host.changeState(Host.DOWN_HARD);
			}
		}
	}
}
