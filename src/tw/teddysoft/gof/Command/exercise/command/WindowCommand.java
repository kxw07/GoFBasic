package tw.teddysoft.gof.Command.exercise.command;

import tw.teddysoft.gof.Command.exercise.Result;
import tw.teddysoft.gof.Command.exercise.Status;
import tw.teddysoft.gof.Command.exercise.sensor.Window;

public class WindowCommand implements Command {

    private final Window window;

    public WindowCommand(String ipAddress) {
        this.window = new Window(ipAddress);
    }

    public WindowCommand(Window window) {
        this.window = window;
    }

    @Override
    public Result execute() {
        final Result result = new Result(Status.OK);

        if (window.isOpen()) {
            result.setStatus(Status.CRITICAL);
            result.setMessage("窗戶被開啟");
        }

        if (window.isBroken()) {
            result.setStatus(Status.CRITICAL);
            result.setMessage("窗戶被打破");
        }

        return result;
    }
}
