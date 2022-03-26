package tw.teddysoft.gof.AbstractFactory.exercise;

public abstract class AbstractFactory {

    abstract Drive createDrive(String type, int index);

    abstract Process createProcess(int id);

    abstract IOPort createIOPort(int address);

    abstract Monitor createMonitor(int id);
}
