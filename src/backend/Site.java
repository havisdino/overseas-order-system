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
    private List<Merchandise> merchandiseList;

    private SiteDatabase db;

    public Site(String code) throws Exception {
        this.code = code;

        this.db = new SQLiteSiteDatabase(Config.getInstance().getDbPath());

        db.loadSiteInfo(code);
        this.name = db.getName();
        this.deliveryInfo = db.getDeliveryInfo();
        this.merchandiseList = db.getMerchandiseList(code);
        this.otherInfo = db.getOtherInfo();
    }


    public void addMerchandise (int quantity, String... merchandiseCodes) throws SQLException {
        for (String merchandiseCode : merchandiseCodes) {
            db.addMerchandise(merchandiseCode, code, quantity);
        }
    }

    public List<Merchandise> getMerchandise () throws SQLException {
        return db.getMerchandiseList(code);
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
