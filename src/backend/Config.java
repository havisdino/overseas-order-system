package backend;

public class Config {
    private String dbPath = "";

    private static Config config;

    private Config() {}

    public Config getInstance() {
        return config;
    }

    public String getDbPath() {
        return dbPath;
    }
}
