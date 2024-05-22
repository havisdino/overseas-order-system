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
<<<<<<< HEAD

    List<SiteInfo> filterSiteInfo(String deliveryDate, List<SiteInfo> siteInfoList) throws SQLException;
=======
    List<Order> getStashedOrders(String oopdDeptID) throws SQLException;
>>>>>>> 866c6896c5f737e46ca048ca877d2163c7f6c890
}
