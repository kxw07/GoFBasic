package tw.teddysoft.gof.State.ansv2;

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
	public void up(Host host) {
		host.changeState(Host.UP_HARD);
	}
	@Override
	public void down(Host host) {
		host.incAttempt();
		if (host.getAttempt () >=  host.getMaxAttempt())
			host.changeState(Host.DOWN_HARD);
	}
}
