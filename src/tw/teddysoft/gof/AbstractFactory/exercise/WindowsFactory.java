package tw.teddysoft.gof.AbstractFactory.exercise;

public class WindowsFactory extends AbstractFactory {
    @Override
    Drive createDrive(String type, int index) {
        return new SimpleDriveFactory().createWindowsDrive(type, index);
    }

    @Override
    Process createProcess(int id) {
        return new WinProcess(id);
    }

    @Override
    IOPort createIOPort(int address) {
        return new WinIOPort(address);
    }

    @Override
    Monitor createMonitor(int id) {
        return new WinMonitor(id);
    }
}
