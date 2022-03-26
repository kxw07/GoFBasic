package tw.teddysoft.gof.State.exercise;

public class DownHard extends State {

    @Override
    void powerOn(Host host) {
        host.doPowerOn();
    }

    @Override
    void powerOff(Host host) {
        System.out.println("Cannot power off under down hard state.");
    }

    @Override
    void check(Host host, CheckResult result) {
        if (CheckResult.UP == result) {
            host.changeState(Host.UP_SOFT);
        } else if (CheckResult.DOWN == result) {
            host.addAttempt();
        }
    }

    @Override
    String diagnostic(Host host) {
        return host.outOfBandDiagnostic();
    }
}
