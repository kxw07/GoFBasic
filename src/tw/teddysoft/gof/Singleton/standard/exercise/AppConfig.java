package tw.teddysoft.gof.Singleton.standard.exercise;

public class AppConfig {

    private static final AppConfig instance = new AppConfig();

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        return instance;
    }
}
