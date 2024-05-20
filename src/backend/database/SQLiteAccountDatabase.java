package backend.database;

import backend.Config;

import java.sql.*;

public class SQLiteAccountDatabase implements AccountDatabase {
    private Connection connection;
    private String url;

    public SQLiteAccountDatabase() {
        String dbPath = Config.getInstance().getDbPath();
        url = "jdbc:sqlite:" + dbPath;
    }

    @Override
    public String findUserRole(String username, String password) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        String query = "select role from account where username = '" + username + "' and password = '" + password +"'";
        ResultSet result = stmt.executeQuery(query);
        String role = result.getString("role");
        stmt.close();
        close();
        return role;
    }

    @Override
    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
