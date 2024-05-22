package model.database;

import model.Order;
import model.OrderCheck;

import java.sql.SQLException;
import java.util.List;

public interface WarehouseDatabase extends Database {
    void createOrderCheck(OrderCheck orderCheck) throws SQLException;
    Order getOrder(String orderID) throws SQLException;
    List<OrderCheck> getOrderCheckList(String warehouseID) throws SQLException;
    List<Order> getOrderList(String salesDepartmentID) throws SQLException;
}