package model.salesdept;

import model.dataholder.Order;
import model.dataholder.RawMerchandise;
import model.database.SQLiteSalesDeptDatabase;
import model.database.SalesDepartmentDatabase;

import java.util.List;

public class OrderPlacer {

    private String id;
    private SalesDepartmentDatabase salesDepartmentDatabase;
    private RawMerchandise rawMerchandise;

    public OrderPlacer(String id) throws Exception {
        this.id = id;
        salesDepartmentDatabase = new SQLiteSalesDeptDatabase();
    }

    public void createOrder(Order order) {
        try {
            salesDepartmentDatabase.createOrder(order);
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

    public List<String> getOOPDeptIDs() {
        try {
            return salesDepartmentDatabase.getOOPDeptIDs();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


