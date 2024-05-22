package backend.database;

import backend.Config;
import backend.Merchandise;
import backend.Order;
import backend.OrderCheck;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SQLiteWarehouseDatabase implements WarehouseDatabase {
    private Connection connection;
    private String url;

    public SQLiteWarehouseDatabase() throws Exception {
        String dbPath = Config.getInstance().getDbPath();
        url = "jdbc:sqlite:" + dbPath;
    }

    @Override
    public void createOrderCheck(OrderCheck orderCheck) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        String query = String.format(
                "insert into ordercheck (id, result, datecreated) values ('%s', '%s', '%s')",
                orderCheck.getId(),
                orderCheck.getStatus(),
                orderCheck.getDateCreatedInString()
        );
        stmt.executeUpdate(query);
        stmt.close();
        close();
    }

    @Override
    public Order getOrder(String orderID) throws SQLException {
        return null;
    }

    @Override
    public List<OrderCheck> getOrderChecks(String warehouseID) throws SQLException {
        return null;
    }

    @Override
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url);
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
