package backend.database;

import backend.RawMerchandise;

public interface RawMerchandiseDabatase {
    RawMerchandise findRawMerchandise(String merchandiseCode);
}
