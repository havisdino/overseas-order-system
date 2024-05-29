package model.dataholder;

public class MerchandiseInfoPair <K, V> {
    private K merchandiseCode;
    private V productQuantity;

    public MerchandiseInfoPair(K merchandiseCode, V productQuantity) {
        this.merchandiseCode = merchandiseCode;
        this.productQuantity = productQuantity;
    }

    public K getMerchandiseCode() {
        return merchandiseCode;
    }

    public V getProductQuantity() {
        return productQuantity;
    }
}
