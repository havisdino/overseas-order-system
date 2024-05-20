package backend;
import java.util.Date;
import java.util.List;


public class Order {
    private String id;
    private List<Merchandise> merchandiseList;
    private Date dateCreate;
    private String description;

    public Order(String id, List<Merchandise> merchandiseList, Date dateCreate, String description) {
        this.id = id;
        this.merchandiseList = merchandiseList;
        this.dateCreate = dateCreate;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
