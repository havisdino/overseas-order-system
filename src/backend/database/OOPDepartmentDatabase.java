package backend.database;

<<<<<<< HEAD
import backend.Order;
import backend.Site;
import java.sql.SQLException;
import java.util.List;
=======
public interface OOPDepartmentDatabase extends Database {
>>>>>>> fe27755fc65dfbe1c8541d69e3928b3cbe11e0d9

public interface OOPDepartmentDatabase {
    List<Order> getOrderList(String OOPDeptID) throws SQLException;
    List<Site> getSites(String merchandiseID) throws SQLException;
}
