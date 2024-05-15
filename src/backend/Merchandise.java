package backend;
import java.time.LocalDate;

public class Merchandise extends RawMerchandise {
    private int quantity;
    private LocalDate deliveryDate;

    public Merchandise(String code, String name, String unit, int quantity, LocalDate deliveryDate) {
        super(code, name, unit);
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
    }

    public int getQuantity() {
        return quantity;
    }
}
