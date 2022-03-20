package tw.teddysoft.gof.TemplateMethod.exercise;

public class DbConfigParser extends ConfigParser {
    public DbConfigParser(String s) {
        super(s);
    }

    @Override
    protected void readConfigFromFile(String aFileName) {
        String read = "Read config data from database: http://127.0.0.1/hsql/mydb parseToken... validate config data built from database...";
        System.out.println(read);
    }

    @Override
    PersonData buildModel() {
        final PersonData personData = new PersonData();
        personData.setName("Kay");
        personData.setHP(100);

        return personData;
    }

    ;
}
