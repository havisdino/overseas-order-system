package backend;

public class Record {
    private String siteCode;
    private String merCode;
    private int inStockQuantity;
    private String unit;

    public Record(String siteCode, String merCode, int inStockQuantity, String unit) {
        this.siteCode = siteCode;
        this.merCode = merCode;
        this.inStockQuantity = inStockQuantity;
        this.unit = unit;
    }
}
