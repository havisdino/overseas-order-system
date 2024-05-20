package backend.database;

import backend.RawMerchandise;

import java.sql.SQLException;
import java.util.List;

public interface RawMerchandiseDatabase {
    RawMerchandise findRawMerchandise(String merchandiseCode) throws SQLException;
    List<RawMerchandise> getMerchandises() throws SQLException;
}
