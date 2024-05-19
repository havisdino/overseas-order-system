package backend;
import java.time.LocalDate;
import java.util.Date;

public class Merchandise extends RawMerchandise {
    private int quantity;
    private Date deliveryDate;

    public Merchandise(String code, String name, String unit, int quantity, Date deliveryDate) {
        super(code, name, unit);
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
    }

    public int getQuantity() {
        return quantity;
    }
}
