package model.dataholder;

public class DeliveryInfo {
    private int deliveryDaysByShip;
    private int deliveryDaysByAir;

    public DeliveryInfo(int deliveryDaysByShip, int deliveryDaysByAir) {
        this.deliveryDaysByShip = deliveryDaysByShip;
        this.deliveryDaysByAir = deliveryDaysByAir;
    }
}
