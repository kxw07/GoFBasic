package tw.teddysoft.gof.State.exercise;

public abstract class State {
    abstract void powerOn(Host host);
    abstract void powerOff(Host host);
    abstract void check(Host host, CheckResult result);
    abstract String diagnostic(Host host);
}
