package tw.teddysoft.gof.SimpleFactory.exercise;

public class SimpleDriveFactory {

    public Drive createDrive(String type, int index) {
        switch(type){
            case "SATA":
                return new SATADrive(index);
            case "USB":
                return new USBDrive(index);
            default:
                throw new RuntimeException("Unsupported drive type: " + type);
        }

    }
}
