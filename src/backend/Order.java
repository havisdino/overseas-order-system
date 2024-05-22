package backend;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;


public class Order {
    private String id;
    private List<Merchandise> merchandiseList;
    private Date dateCreate;
    private String description;
    private String salesDeptID;
    private String oopDeptID;

    public Order(List<Merchandise> merchandiseList, Date dateCreate, String description, String salesDeptID, String oopDeptID) {
        this.id = String.valueOf(System.currentTimeMillis());
        this.merchandiseList = merchandiseList;
        this.dateCreate = dateCreate;
        this.description = description;
        this.salesDeptID = salesDeptID;
        this.oopDeptID = oopDeptID;
    }

    public Order(String id, List<Merchandise> merchandiseList, Date dateCreate, String description) {
        this.id = id;
        this.merchandiseList = merchandiseList;
        this.dateCreate = dateCreate;
        this.description = description;
    }

    public Order(String id, List<Merchandise> merchandiseList, Date dateCreate, String description, String salesDeptID) {
        this.id = id;
        this.merchandiseList = merchandiseList;
        this.dateCreate = dateCreate;
        this.description = description;
        this.salesDeptID = salesDeptID;
    }

    public Order(String id, String oopDeptID) {
        this.id = id;
        this.oopDeptID = oopDeptID;
    }

    public String getOopDeptID() {
        return oopDeptID;
    }


    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public List<Merchandise> getMerchandiseList() {
        return merchandiseList;
    }

    public Date getDateCreated() {
        return dateCreate;
    }

    public String getDateCreatedInString() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String datecreate = dateFormat.format(dateCreate);
        return datecreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public String getSalesDeptID() {
        return salesDeptID;
    }
}
