package backend;

import java.util.ArrayList;

public class SalesDepartment {
    SalesDepartmentDatabase salesDepartmentDatabase;
    RawMerchandise rawMerchandise;
    private ArrayList<Order> orderList;

    public SalesDepartment() {
        this.orderList = new ArrayList<>();
    }

    public SalesDepartment(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }


    public void createOrder(Order order) {

    }



    @Override
    public RawMerchandise findRawMerchandise(String merchandiseCode) {
        return null;
    }
}


