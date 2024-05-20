package backend.database;

import backend.RawMerchandise;

import java.sql.SQLException;
import java.util.List;

public interface RawMerchandiseDatabase extends Database {
    RawMerchandise findRawMerchandise(String merchandiseCode) throws SQLException;
    List<RawMerchandise> getMerchandises() throws SQLException;
    List<RawMerchandise> getMerchandisesExceptSite(String siteCode) throws SQLException;
}
