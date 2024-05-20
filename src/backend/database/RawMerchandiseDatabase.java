package backend.database;

import backend.RawMerchandise;

public interface RawMerchandiseDatabase {
    RawMerchandise findRawMerchandise(String merchandiseCode);
}
