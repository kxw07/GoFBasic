package tw.teddysoft.gof.Command.exercise.command;

import tw.teddysoft.gof.Command.exercise.Result;
import tw.teddysoft.gof.Command.exercise.Status;
import tw.teddysoft.gof.Command.exercise.sensor.Thermal;

public class ThermalCommand implements Command {

    private final Thermal thermal;

    public ThermalCommand(String ipAddress) {
        this.thermal = new Thermal(ipAddress);
    }

    public ThermalCommand(Thermal thermal) {
        this.thermal = thermal;
    }

    @Override
    public Result execute() {
        final Result result = new Result(Status.OK);

        if (this.thermal.isOverheat()) {
            result.setStatus(Status.CRITICAL);
            result.setMessage("溫度過熱");
        }

        return result;
    }
}
