package backend.database;

import backend.Order;
import backend.SiteInfo;

import java.sql.SQLException;
import java.util.List;

public interface OOPDepartmentDatabase extends Database {
    List<Order> getOrderList(String OOPDeptID) throws SQLException;
    void removeStashedOrder(String orderID) throws SQLException;
    void addCancelledOrder(String orderID, String note) throws SQLException;
    List<SiteInfo> getSiteInfo(String merchandiseCode) throws SQLException;
    List<SiteInfo> filterSiteInfo(String deliveryDate, List<SiteInfo> siteInfoList) throws SQLException;
    void addStashedOrder(String orderID) throws SQLException;
    List<Order> getStashedOrders(String oopdDeptID) throws SQLException;
}
