package tw.teddysoft.gof.State.ansv2;

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
	public void up(Host host) {
		host.incAttempt();		
	}
	@Override
	public void down(Host host) {
		host.changeState(Host.DOWN_SOFT);
	}
}
