package backend.database;

import backend.Order;
import backend.SiteInfo;

import java.sql.SQLException;
import java.util.List;

public interface OOPDepartmentDatabase extends Database {
    List<Order> getOrderList(String OOPDeptID) throws SQLException;
    void addStashedOrder(String orderID) throws SQLException;
    void removeStashedOrder(String orderID) throws SQLException;
    void addCancelledOrder(String orderID) throws SQLException;
    List<SiteInfo> getSiteInfo(String merchandiseCode) throws SQLException;
    List<Order> getStashedOrders(String oopdDeptID) throws SQLException;
}
