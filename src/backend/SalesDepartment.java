package backend;
import backend.database.SalesDepartmentDatabase;

import java.util.List;

public class SalesDepartment {

    private String id;
    private SalesDepartmentDatabase salesDepartmentDatabase;
    private RawMerchandise rawMerchandise;

    public SalesDepartment(String id) {
        this.id = id;
        // initialize the databases
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


