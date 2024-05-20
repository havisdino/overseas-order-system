package backend.database;

import java.sql.SQLException;

public interface AccountDatabase {
    String findUserRole(String username, String password) throws SQLException;
}
