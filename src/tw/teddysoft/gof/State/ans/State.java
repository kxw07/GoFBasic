package tw.teddysoft.gof.State.ans;

public interface State {
	void powerOff(Host host);
	void powerOn(Host host);
	String diagnostic(Host host);
	void check(Host host, CheckResult result);
}
