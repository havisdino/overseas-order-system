package model.database;

import model.dataholder.Order;

import java.sql.SQLException;
import java.util.List;

public interface SalesDepartmentDatabase extends Database {
    void createOrder(Order order) throws SQLException;

    List<Order> getOrderList(String salesDepartmentID) throws SQLException;
    List<String> getOOPDeptIDs() throws SQLException;
}
