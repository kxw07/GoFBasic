package tw.teddysoft.gof.AbstractFactory.exercise;

public class LinuxFactory extends AbstractFactory {
    @Override
    Drive createDrive(String type, int index) {
        return new SimpleDriveFactory().createLinuxDrive(type, index);
    }

    @Override
    Process createProcess(int id) {
        return new LinuxProcess(id);
    }

    @Override
    IOPort createIOPort(int address) {
        return  new LinuxIOPort(address);
    }

    @Override
    Monitor createMonitor(int id) {
        return new LinuxMonitor(id);
    }
}
