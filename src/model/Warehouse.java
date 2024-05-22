package model;

import model.database.SQLiteWarehouseDatabase;
import model.database.WarehouseDatabase;

import java.util.List;

public class Warehouse {
    private String id;
    private WarehouseDatabase db;

    public Warehouse(String id) throws Exception {
        this.id = id;
        db = new SQLiteWarehouseDatabase();
    }

    public void getRawMerchandise() {
        // doi a gia anh
    }

    public void createOrderCheck(OrderCheck orderCheck) throws Exception {
        orderCheck.setWarehouseID(id);
        Order orderPlaced = db.getOrder(orderCheck.getId());
        String status = check(orderPlaced, orderCheck);
        orderCheck.setStatus(status);
        db.createOrderCheck(orderCheck);
    }

    public List<OrderCheck> getOrderChecks() throws Exception {
        return db.getOrderCheckList(id);
    }

    private String check(Order a, Order b) {
        String distinct = "Distinct";
        String identical = "Identical";

        List<Merchandise> ma = a.getMerchandiseList();
        List<Merchandise> mb = b.getMerchandiseList();

        if (ma.size() != mb.size()) {
            return distinct;
        }

        for (Merchandise m : ma) {
            if (!mb.contains(m)) {
                return distinct;
            }
        }
        return identical;
    }

    public Order getOrder(String orderID) {
        try {
            return db.getOrder(orderID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<OrderCheck> getOrderCheckList() {
        try {
            return db.getOrderCheckList(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
