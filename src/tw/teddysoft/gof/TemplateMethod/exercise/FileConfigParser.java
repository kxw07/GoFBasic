package tw.teddysoft.gof.TemplateMethod.exercise;

public class FileConfigParser extends ConfigParser {
    public FileConfigParser(String s) {
        super(s);
    }

    @Override
    protected void readConfigFromFile(String aFileName) {
        String read = "Read config data from file: C:\\config.ini parseToken... validate config data built from file...";
        System.out.println(read);
    }

    @Override
    PersonData buildModel() {
        final PersonData personData = new PersonData();
        personData.setName("Teddy");
        personData.setHP(100);

        return personData;
    }
}
