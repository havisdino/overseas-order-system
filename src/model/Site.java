package model;

import model.database.SQLiteSiteDatabase;
import model.database.SiteDatabase;

import java.sql.SQLException;
import java.util.List;

public class Site {
    private String code;
    private DeliveryInfo deliveryInfo;
    private String name;
    private String otherInfo;
    private List<Merchandise> merchandiseList;

    private SiteDatabase db;

    public Site(String code) throws Exception {
        this.code = code;

        this.db = new SQLiteSiteDatabase();

        db.loadSiteInfo(code);
        this.name = db.getName();
        this.deliveryInfo = db.getDeliveryInfo();
        this.otherInfo = db.getOtherInfo();
        this.merchandiseList = db.getMerchandiseList(code);
    }


    public void addMerchandise(int quantity, String merchandiseCode) throws SQLException {
        db.addMerchandise(merchandiseCode, code, quantity);
        merchandiseList = db.getMerchandiseList(code);
    }

    public List<Merchandise> getMerchandise() {
        return merchandiseList;
    }

    public void deleteMerchandise(String... merchandiseCodes) {
        for (String code : merchandiseCodes) {
//            db.deleteMerchandise(code)
        }
    }

    public void editMerchandise(MerchandiseInfoPair<String, Integer>... merchandiseInfoPairs) {
        for (MerchandiseInfoPair<String, Integer> merchandiseInfoPair : merchandiseInfoPairs) {
//            db.edit(merchandiseInfoPair.getMerchandiseCode(), merchandiseInfoPair.getProductQuantity());
        }
    }

    public void handleRequest (MerchandiseInfoPair<String, Integer>... merchandiseInfoPairs) {

    }
}
