package backend.database;

import backend.DeliveryInfo;
import backend.Merchandise;
import java.sql.SQLException;
import java.util.List;

public interface SiteDatabase {
    void addMerchandise(String merchandiseCode, String siteCode, int quantity) throws SQLException;
    void deleteMerchandise(String merchandiseCode, String siteCode) throws SQLException;
    void editMerchandise(String merchandiseCode, String siteCode, int merchandiseQuantity) throws SQLException;
    List<Merchandise> getMerchandiseList(String siteCode) throws SQLException;
    void loadSiteInfo(String siteCode) throws SQLException;
    String getName();
    DeliveryInfo getDeliveryInfo();

    String getOtherInfo();
}
