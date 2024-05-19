package backend;
import java.util.Date;
import java.util.List;


public class Order {
    private String id;
    private List<Merchandise> merchandiseList;
    private Date dateCreate;

    public Order(String id, List<Merchandise> merchandiseList, Date dateCreate) {
        this.id = id;
        this.merchandiseList = merchandiseList;
        this.dateCreate = dateCreate;
    }

}
