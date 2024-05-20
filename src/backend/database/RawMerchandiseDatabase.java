package backend.database;

import backend.RawMerchandise;

<<<<<<< HEAD
public interface RawMerchandiseDatabase {
    RawMerchandise findRawMerchandise(String merchandiseCode);
=======
import java.sql.SQLException;
import java.util.List;

public interface RawMerchandiseDatabase {
    RawMerchandise findRawMerchandise(String merchandiseCode) throws SQLException;
    List<RawMerchandise> getMerchandises() throws SQLException;
>>>>>>> 95c0ed0d8609d20ea30d5d2a4d5a9deb076c6c9a
}
