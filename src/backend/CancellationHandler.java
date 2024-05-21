package backend;

import backend.database.OOPDepartmentDatabase;
import backend.database.SQLiteOOPDeptDatabase;

public class CancellationHandler {
    String oopdDeptID;
    OOPDepartmentDatabase db;

    public CancellationHandler(String oopDeptID) throws Exception {
        this.oopdDeptID = oopDeptID;
         db = new SQLiteOOPDeptDatabase();
    }

    public void stashOrder(String orderID) throws Exception {
        db.stashOrder(orderID);
    }

    public void removeStashedOrder(String orderID) throws Exception {
        db.removeStashedOrder(orderID);
    }

    public void addCancelledOrder(String orderID) {
        // ************
        //
    }
}
