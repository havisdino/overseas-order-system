package backend.database;
import backend.DeliveryInfo;
import backend.Merchandise;

import java.sql.SQLException;
import java.util.List;

public interface SiteDatabase extends Database {
    void addMerchandise(String merchandiseCode, String siteCode, int quantity) throws SQLException;
    List<Merchandise> getMerchandiseList(String siteCode) throws SQLException;

    void loadSiteInfo(String siteCode) throws SQLException;
    String getName();
    DeliveryInfo getDeliveryInfo();
    String getOtherInfo();
}
