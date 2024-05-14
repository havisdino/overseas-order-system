package backend;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private ArrayList<Merchandise> merchandiseList;
    private int id;
    private LocalDate deliveryDate;
    public Order(ArrayList<Merchandise> merchandiseList, int id, LocalDate deliveryDate) {
        this.merchandiseList = merchandiseList;
        this.id = id;
        this.deliveryDate = deliveryDate;
    }
}
