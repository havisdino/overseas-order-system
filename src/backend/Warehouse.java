package backend;

import backend.database.SQLiteWarehouseDatabase;
import backend.database.WarehouseDatabase;

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
        return db.getOrderChecks(id);
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
}
