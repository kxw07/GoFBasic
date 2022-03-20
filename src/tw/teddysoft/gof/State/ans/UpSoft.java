package tw.teddysoft.gof.State.ans;

public class UpSoft implements State {
	@Override
	public void powerOff(Host host) {
		host.doPowerOff(60);
	}
	@Override
	public void powerOn(Host host) {
		System.out.println("Cannot power on under up soft state.");
	}
	@Override
	public String diagnostic(Host host) {
		String result = host.inBandDiagnostic();
		if ("" == result)
			return host.outOfBandDiagnostic();
		else 
			return result;
	}
	@Override
	public void check(Host host, CheckResult result) {
		if (CheckResult.UP == result) {
			host.incAttempt();
			if (host.getAttempt() >=  host.getMaxAttempt())
				host.changeState(Host.UP_HARD);
		}
		else if (CheckResult.DOWN == result) {
			host.changeState(Host.DOWN_HARD);
		}
	}
}
