package model;

public class Config {
    private String dbPath = "sys.db";
    private String username;
    private String password;
    private String role;

    private static Config config = null;

    private Config() {}

    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public String getDbPath() {
        return dbPath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
