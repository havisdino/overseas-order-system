package backend;

import java.util.Date;
import java.util.List;

public class OrderCheck extends Order {
    private String warehouseID;
    private String status;

    public OrderCheck(List<Merchandise> merchandiseList, Date dateCreated, String description, String salesDeptID, String oopDeptID) {
        super(merchandiseList, dateCreated, description, salesDeptID, oopDeptID);
    }

    public OrderCheck(List<Merchandise> merchandiseList, Date dateCreated, String description, String salesDeptID, String oopDeptID, String warehouseID) {
        super(merchandiseList, dateCreated, description, salesDeptID, oopDeptID);
        this.warehouseID = warehouseID;
    }

    public OrderCheck(String id, List<Merchandise> merchandiseList, Date dateCreated, String status) {
        super(id, merchandiseList, dateCreated);
        this.status = status;
    }

    public OrderCheck(String id, List<Merchandise> merchandiseList, Date dateCreated, String description, String salesDeptID, String warehouseID) {
        super(id, merchandiseList, dateCreated, description, salesDeptID);
        this.warehouseID = warehouseID;
    }



    public OrderCheck(String id, String oopDeptID, Date dateCreated) {
        super(id, oopDeptID, dateCreated);
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getWarehouseID() {
        return warehouseID;
    }

}
