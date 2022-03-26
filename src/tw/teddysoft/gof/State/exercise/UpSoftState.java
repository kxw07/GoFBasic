package tw.teddysoft.gof.State.exercise;

public class UpSoftState extends State {
    @Override
    void powerOn(Host host) {
        System.out.println("Cannot power on under up soft state.");
    }

    @Override
    void powerOff(Host host) {
        host.doPowerOff(60);
    }

    @Override
    void check(Host host, CheckResult result) {
        if (CheckResult.UP == result) {
            host.addAttempt();
            if (host.getAttempt() >= host.getMaxAttempt())
                host.changeState(Host.UP_HARD);
        } else if (CheckResult.DOWN == result) {
            host.changeState(Host.DOWN_HARD);
        }
    }

    @Override
    String diagnostic(Host host) {
        String result = host.inBandDiagnostic();
        if ("".equals(result))
            return host.outOfBandDiagnostic();
        else
            return result;
    }
}
