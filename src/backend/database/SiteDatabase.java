package backend.database;

import backend.Merchandise;
import backend.Order;

import java.sql.SQLException;
import java.util.List;

public interface SiteDatabase {
    void addMerchandise(String merchandiseCode, String siteCode) throws SQLException;
    void deleteMerchandise(String merchandiseCode, String siteCode) throws SQLException;
    void editMerchandise(String merchandiseCode, String siteCode, int merchandiseQuantity) throws SQLException;
    List<Merchandise> getMerchandiseList(String siteCode) throws SQLException;
}
