package backend.database;

import backend.Config;
import backend.Merchandise;
import backend.Order;
import backend.Site;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteOOPDeptDatabase implements OOPDepartmentDatabase {
    private Connection connection;
    private String url;

    public SQLiteOOPDeptDatabase() throws Exception {
        String dbPath = Config.getInstance().getDbPath();
        url = "jdbc:sqlite:" + dbPath;
    }

    @Override
    public List<Order> getOrderList(String OOPDeptID) throws SQLException {
        Statement stmt = connection.createStatement();

        String query = "select id from order_ where oopdeptid =" + OOPDeptID;
        ResultSet results = stmt.executeQuery(query);
        stmt.close();
        return null;
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
