package tw.teddysoft.gof.FactoryMethod.exercise;

public class WinDriveManager implements DriveManager {
    @Override
    public Drive getDrive(String type, int index) {
        Drive drive;
        switch(type){
            case "SATA":
                drive = new WinSATADrive(index);
                break;
            case "USB":
                drive = new WinUSBDrive(index);
                break;
            default:
                throw new RuntimeException
                        ("Unsupported drive type: " + type);
        }
        return drive;
    }
}
