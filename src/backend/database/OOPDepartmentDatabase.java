package backend.database;

import backend.Order;
import backend.Site;
import java.sql.SQLException;
import java.util.List;

public interface OOPDepartmentDatabase {
    List<Order> getOrderList(String OOPDeptID) throws SQLException;
    List<Site> getSites(String merchandiseID) throws SQLException;
}
