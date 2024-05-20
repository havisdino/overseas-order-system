package backend.database;

import backend.Config;

import java.sql.*;

public class SQLiteAccountDatabase implements AccountDatabase {
    Connection connection;

    public SQLiteAccountDatabase() throws Exception {
        String dbPath = Config.getInstance().getDbPath();
        String url = "jdbc:sqlite:" + dbPath;
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public String findUserRole(String username, String password) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = "select role from account where username = '" + username + "' and password = '" + password +"'";
        ResultSet result = stmt.executeQuery(query);
        return result.getString("role");
    }
}
