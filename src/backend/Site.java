package backend;

import java.util.ArrayList;

public class Site {
    private String code;
    private DeliveryInfo deliveryInfo;
    private String name;
    private String otherInfo;
    private SiteDatabase db;
    ArrayList<Merchandise> merchandiseList;

//    public int findMerchandise (String merchandiseCode) {
//        return db.countProduct(merchandiseCode)
//    }
    public void addMerchandise (String... merchandiseCodes) {
        for (String code : merchandiseCodes) {
//            db.addMerchandise(code)
        }
    }

    public void deleteMerchandise (String... merchandiseCodes) {
        for (String code : merchandiseCodes) {
//            db.deleteMerchandise(code)
        }
    }

    public void editMerchandise (MerchandiseInfoPair<String, Integer>... merchandiseInfoPairs) {
        for (MerchandiseInfoPair<String, Integer> merchandiseInfoPair : merchandiseInfoPairs) {
//            db.edit(merchandiseInfoPair.getMerchandiseCode(), merchandiseInfoPair.getProductQuantity());
        }
    }

    public void handleRequest (MerchandiseInfoPair<String, Integer>... merchandiseInfoPairs) {

    }
}
