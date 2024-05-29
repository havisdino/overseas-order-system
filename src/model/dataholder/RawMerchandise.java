package model.dataholder;

public class RawMerchandise {
    private String code;
    private String name;
    private String unit;

    public RawMerchandise(String code, String name, String unit) {
        this.code = code;
        this.name = name;
        this.unit = unit;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

}
