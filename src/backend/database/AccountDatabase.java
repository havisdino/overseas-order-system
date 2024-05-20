package backend.database;

import java.sql.SQLException;

public interface AccountDatabase extends Database {
    String findUserRole(String username, String password) throws SQLException;
}
