package backend;

import java.util.List;

public class OOPDepartment {
    private List<Record> recordList;
    private List<Order> orderList;


    public OOPDepartment(List<Order> orderList) {
        this.orderList = orderList;
    }

}