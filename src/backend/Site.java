package backend;

import backend.database.SQLiteSiteDatabase;
import backend.database.SiteDatabase;

import java.sql.SQLException;
import java.util.List;

public class Site {
    private String code;
    private DeliveryInfo deliveryInfo;
    private String name;
    private String otherInfo;

    private SiteDatabase db;

    public Site(String code, DeliveryInfo deliveryInfo, String name, String otherInfo, SiteDatabase db) throws Exception {
        this.code = code;
        this.deliveryInfo = deliveryInfo;
        this.name = name;
        this.otherInfo = otherInfo;
        this.db = new SQLiteSiteDatabase("");
    }

//    public int findMerchandise (String merchandiseCode) {
//        return db.countProduct(merchandiseCode)
//    }
    public void addMerchandise (int quantity, String... merchandiseCodes) throws SQLException {
        for (String merchandiseCode : merchandiseCodes) {
            db.addMerchandise(merchandiseCode, code, quantity);
        }
    }

    public void getMerchandise () throws SQLException {
        db.getMerchandiseList(code);
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
