package backend.database;

import backend.Merchandise;
import backend.Order;
import backend.Site;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteOOPDeptDatabase implements OOPDepartmentDatabase {
    private Connection connection;

    public SQLiteOOPDeptDatabase(String dbPath) throws Exception {
        String url = "jdbc:sqlite:" + dbPath;
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public List<Order> getOrderList(String OOPDeptID) throws SQLException {
        Statement stmt = connection.createStatement();

        String query = "select id from order_ where oopdeptid =" + OOPDeptID;
        ResultSet results = stmt.executeQuery(query);
    }

    @Override
    public List<Site> getSites(String merchandiseID) throws SQLException {
        return null;
    }
}
