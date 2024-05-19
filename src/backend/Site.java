package backend;

import backend.database.SiteDatabase;

import java.sql.SQLException;
import java.util.List;

public class Site {
    private String code;
    private DeliveryInfo deliveryInfo;
    private String name;
    private String otherInfo;

    private SiteDatabase db;

    List<Merchandise> merchandiseList;

//    public int findMerchandise (String merchandiseCode) {
//        return db.countProduct(merchandiseCode)
//    }
    public void addMerchandise (String... merchandiseCodes) throws SQLException {
        for (String merchandiseCode : merchandiseCodes) {
            db.addMerchandise(merchandiseCode, code);
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
