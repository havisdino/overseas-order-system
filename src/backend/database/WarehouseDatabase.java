package backend.database;

import backend.Order;

import java.sql.SQLException;

public interface WarehouseDatabase {
    void createOrderCheck(Order order, String warehouseID) throws SQLException;
}
