package backend;

import java.util.Date;

public class Merchandise extends RawMerchandise {
    private int quantity;
    private Date deliveryDate;

    public Merchandise(String code, String name, String unit, int quantity, Date deliveryDate) {
        super(code, name, unit);
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
    }

    public Merchandise(String code, String name, String unit, int quantity) {
        super(code, name, unit);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }
}
