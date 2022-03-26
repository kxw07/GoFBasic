package tw.teddysoft.gof.State.exercise;

public class UpHardState extends State {

    @Override
    void powerOn(Host host) {
        System.out.println("Cannot power on under up hard state.");
    }

    @Override
    void powerOff(Host host) {
        host.doGracefulPowerOff();
    }

    @Override
    void check(Host host, CheckResult result) {
        if (CheckResult.UP == result) {
            host.addAttempt();
        } else if (CheckResult.DOWN == result) {
            host.changeState(Host.DOWN_SOFT);
        }
    }

    @Override
    String diagnostic(Host host) {
        return host.inBandDiagnostic();
    }
}
