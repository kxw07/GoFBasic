package tw.teddysoft.gof.State.ansv2;

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
	public void up(Host host) {
		host.changeState(Host.UP_SOFT);
	}
	@Override
	public void down(Host host) {
		host.incAttempt();
	}
}
