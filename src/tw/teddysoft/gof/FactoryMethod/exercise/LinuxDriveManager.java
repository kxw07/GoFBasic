package tw.teddysoft.gof.FactoryMethod.exercise;

public class LinuxDriveManager implements DriveManager {

    @Override
    public Drive getDrive(String type, int index) {
        Drive drive;
        switch(type){
            case "SATA":
                drive = new LinuxSATADrive(index);
                break;
            case "USB":
                drive = new LinuxUSBDrive(index);
                break;
            default:
                throw new RuntimeException
                        ("Unsupported drive type: " + type);
        }
        return drive;
    }
}
