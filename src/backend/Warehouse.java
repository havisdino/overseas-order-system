package backend;

import backend.database.WarehouseDatabase;

public class Warehouse {
    private String id;
    private WarehouseDatabase warehouseDatabase;

    public Warehouse(String id) {
        this.id = id;
        // initialize the databases
    }

    public void getRawMerchandise() {
        // doi a gia anh
    }

    public void createOrderCheck(Order order) {
        try {
            warehouseDatabase.createOrderCheck(order, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
