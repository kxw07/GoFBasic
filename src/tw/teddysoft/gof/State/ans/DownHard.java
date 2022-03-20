package tw.teddysoft.gof.State.ans;

public class DownHard implements State {

	@Override
	public void powerOff(Host host) {
		System.out.println("Cannot power off under down hard state.");
	}

	@Override
	public void powerOn(Host host) {
		host.doPowerOn();
	}

	@Override
	public String diagnostic(Host host) {
		return host.outOfBandDiagnostic();
	}

	@Override
	public void check(Host host, CheckResult result) {
		if (CheckResult.UP == result) {
			host.changeState(Host.UP_SOFT);
		}
		else if (CheckResult.DOWN == result) {
			host.incAttempt();
		}
	}
}
