package backend.database;

import backend.Order;

import java.sql.SQLException;
import java.util.List;

public interface WarehouseDatabase {
    void createOrderCheck(Order order, String warehouseID) throws SQLException;
}
