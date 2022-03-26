package tw.teddysoft.gof.State.exercise;

public class DownSoft extends State {

    @Override
    void powerOn(Host host) {
        System.out.println("Cannot power on under down soft state.");
    }

    @Override
    void powerOff(Host host) {
        System.out.println("Cannot power off under down soft state.");
    }

    @Override
    void check(Host host, CheckResult result) {
        if (CheckResult.UP == result) {
            host.changeState(Host.UP_HARD);
        } else if (CheckResult.DOWN == result) {
            host.addAttempt();
            if (host.getAttempt() >= host.getMaxAttempt()) {
                host.changeState(Host.DOWN_HARD);
            }
        }
    }

    @Override
    String diagnostic(Host host) {
        return host.outOfBandDiagnostic();
    }
}
