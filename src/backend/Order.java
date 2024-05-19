package backend;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Merchandise> merchandiseList;
    public Order(int id, ArrayList<Merchandise> merchandiseList) {
        this.id = id;
        this.merchandiseList = merchandiseList;
    }

}
