package backend;

import java.util.ArrayList;

public class OOPDepartment {
    private ArrayList<Record> recordList;
    private ArrayList<Order> orderList;

    public OOPDepartment(ArrayList<Record> recordList) {
        this.recordList = recordList;
    }

    public OOPDepartment(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }



}




