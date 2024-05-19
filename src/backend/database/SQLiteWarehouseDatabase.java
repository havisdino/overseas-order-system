package backend.database;

import backend.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

public class SQLiteWarehouseDatabase implements WarehouseDatabase {
    private Connection connection;

    public SQLiteWarehouseDatabase(String dbPath) throws Exception {
        String url = "jdbc:sqlite:" + dbPath;
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public void createOrderCheck(Order order, String wareHouseID) throws SQLException {
        Statement stmt = connection.createStatement();
        String id = String.valueOf(Instant.now().getEpochSecond());
        String query = "insert into order (id, warehouseid) values (" +
                id + "," + wareHouseID + ")" ;
        stmt.executeUpdate(query);
        stmt.close();
    }
}
