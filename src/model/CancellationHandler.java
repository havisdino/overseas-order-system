package model;

import model.database.OOPDepartmentDatabase;
import model.database.SQLiteOOPDeptDatabase;

import java.util.List;

public class CancellationHandler {
    String oopDeptID;
    OOPDepartmentDatabase db;

    public CancellationHandler(String oopDeptID) throws Exception {
        this.oopDeptID = oopDeptID;
         db = new SQLiteOOPDeptDatabase();
    }

    public List<Order> getStashedOrders() throws Exception {
        return db.getStashedOrders(oopDeptID);
    }

    public void stashOrder(String orderID) throws Exception {
        db.addStashedOrder(orderID);
    }

    public void removeStashedOrder(String orderID) throws Exception {
        db.removeStashedOrder(orderID);
    }

    public void addCancelledOrder(String orderID, String note) throws Exception {
        db.addCancelledOrder(orderID, note);
    }
}
