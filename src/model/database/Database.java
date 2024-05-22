package model.database;

import java.sql.SQLException;

public interface Database {
    void connect() throws SQLException;
    void close() throws SQLException;
}
