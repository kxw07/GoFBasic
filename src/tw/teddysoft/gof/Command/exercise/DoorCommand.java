package tw.teddysoft.gof.Command.exercise;

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
