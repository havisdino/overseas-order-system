package backend;
import backend.database.SQLiteSalesDeptDatabase;
import backend.database.SalesDepartmentDatabase;

import java.sql.SQLException;
import java.util.List;

public class SalesDepartment {

    private String id;
    private SalesDepartmentDatabase salesDepartmentDatabase;
    private RawMerchandise rawMerchandise;

    public SalesDepartment(String id) throws Exception {
        this.id = id;
        salesDepartmentDatabase = new SQLiteSalesDeptDatabase();
    }

    public void createOrder(Order order) {
        try {
            salesDepartmentDatabase.createOrder(order, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Order> getOrderList() {
        try {
            return salesDepartmentDatabase.getOrderList(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


