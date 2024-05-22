package backend;

import java.util.Date;
import java.util.List;

public class NotedOrder extends Order {
    private String note;

    public NotedOrder(List<Merchandise> merchandiseList, Date dateCreate, String description, String salesDeptID, String oopDeptID) {
        super(merchandiseList, dateCreate, description, salesDeptID, oopDeptID);
    }

    public NotedOrder(String id, List<Merchandise> merchandiseList, Date dateCreate, String description) {
        super(id, merchandiseList, dateCreate, description);
    }

    public NotedOrder(String id, List<Merchandise> merchandiseList, Date dateCreate, String description, String salesDeptID) {
        super(id, merchandiseList, dateCreate, description, salesDeptID);
    }

    public NotedOrder(String id, String oopDeptID, String note) {
        super(id, oopDeptID);
        this.note = note;
    }
}
