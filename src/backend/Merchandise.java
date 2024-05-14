package backend;

public class Merchandise {
    private String code;
    private String name;
    private String unit;
    private int quantity;

    public Merchandise() {

    }

    public Merchandise(String code, String name, String unit, int quantity) {
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }
}
