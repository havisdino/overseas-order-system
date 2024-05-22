package model;

public class SiteInfo {
    String code;
    String name;
    int quantity;
    int daysByShip;
    int daysByAir;

    public SiteInfo(String code, String name, int quantity, int daysByShip, int daysByAir) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.daysByShip = daysByShip;
        this.daysByAir = daysByAir;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getDaysByShip() {
        return daysByShip;
    }

    public int getDaysByAir() {
        return daysByAir;
    }

    public int getQuantity() {
        return quantity;
    }
}
