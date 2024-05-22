package backend;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Order {
    private String id;
    private List<Merchandise> merchandiseList;
    private Date dateCreated;
    private String description;
    private String salesDeptID;
    private String oopDeptID;

    public Order(List<Merchandise> merchandiseList, Date dateCreated, String description, String salesDeptID, String oopDeptID) {
        this.id = String.valueOf(System.currentTimeMillis());
        this.merchandiseList = merchandiseList;
        this.dateCreated = dateCreated;
        this.description = description;
        this.salesDeptID = salesDeptID;
        this.oopDeptID = oopDeptID;
    }

    public Order(String id, List<Merchandise> merchandiseList, Date dateCreated, String description) {
        this.id = id;
        this.merchandiseList = merchandiseList;
        this.dateCreated = dateCreated;
        this.description = description;
    }

    public Order(String id, List<Merchandise> merchandiseList, Date dateCreated, String description, String salesDeptID) {
        this.id = id;
        this.merchandiseList = merchandiseList;
        this.dateCreated = dateCreated;
        this.description = description;
        this.salesDeptID = salesDeptID;
    }

    public Order(String id, String oopDeptID, Date dateCreated) {
        this.dateCreated = dateCreated;
        this.id = id;
        this.oopDeptID = oopDeptID;
    }

    public Order() {
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

    public String getDateCreatedInString() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String date = dateFormat.format(dateCreated);
        return date;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getSalesDeptID() {
        return salesDeptID;
    }

    public void setMerchandiseList(List<Merchandise> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }
}
