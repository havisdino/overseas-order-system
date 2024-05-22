package backend;

import java.util.Date;
import java.util.List;

public class OrderCheck extends Order {
    private String warehouseID;
    private String status;

    public OrderCheck(List<Merchandise> merchandiseList, Date dateCreated, String description, String salesDeptID, String oopDeptID) {
        super(merchandiseList, dateCreated, description, salesDeptID, oopDeptID);
    }

    public OrderCheck(String id, List<Merchandise> merchandiseList, Date dateCreated, String description) {
        super(id, merchandiseList, dateCreated, description);
    }

    public OrderCheck(String id, List<Merchandise> merchandiseList, Date dateCreated, String description, String salesDeptID) {
        super(id, merchandiseList, dateCreated, description, salesDeptID);
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
}
