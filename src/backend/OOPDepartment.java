package backend;
import backend.database.OOPDepartmentDatabase;

import java.util.List;

public class OOPDepartment {
    String id;
    private List<Order> orderList;
    private OOPDepartmentDatabase oopDepartmentDatabase;

    public OOPDepartment(String id, List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        try {
            return oopDepartmentDatabase.getOrderList(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Site> getSites() {
        try {
            return ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}




