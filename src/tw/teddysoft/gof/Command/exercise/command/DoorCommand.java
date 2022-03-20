package tw.teddysoft.gof.Command.exercise.command;

import tw.teddysoft.gof.Command.exercise.sensor.Door;
import tw.teddysoft.gof.Command.exercise.Result;
import tw.teddysoft.gof.Command.exercise.Status;

public class DoorCommand implements Command {

    private final Door door;

    public DoorCommand(String ipAddress) {
        this.door = new Door(ipAddress);
    }

    public DoorCommand(Door door) {
        this.door = door;
    }

    @Override
    public Result execute() {
        final Result result = new Result(Status.OK);
        if ("open".equals(door.getDoorStatus())) {
            result.setStatus(Status.CRITICAL);
            result.setMessage("門被打開");
        }

        return result;
    }
}
