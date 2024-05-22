package backend.database;

import backend.Order;
import backend.Site;
import backend.SiteInfo;

import java.sql.SQLException;
import java.util.List;

public interface OOPDepartmentDatabase extends Database {
    List<Order> getOrderList(String OOPDeptID) throws SQLException;

    List<SiteInfo> getSiteInfo(String merchandiseCode) throws SQLException;

    List<SiteInfo> filterSiteInfo(String deliveryDate, List<SiteInfo> siteInfoList) throws SQLException;
}
