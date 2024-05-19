package backend.database;

public interface AccountDatabase {
    String findUserRole(String usernme, String password);
}
