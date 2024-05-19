package backend.database;

import backend.Merchandise;
import backend.Site;

import java.sql.*;
import java.time.Instant;
import java.util.List;

public class SQLiteSiteDatabase implements SiteDatabase {
    private Connection connection;
    public SQLiteSiteDatabase(String dbPath) throws Exception {
        String url = "jdbc:sqlite:" + dbPath;
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public void addMerchandise(String merchandiseCode, String siteCode) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = "insert into site_merchandise (siteCode, merchandiseCode) values (" +
                siteCode + "," + merchandiseCode + ")";
        stmt.executeUpdate(query);
        stmt.close();
    }

    @Override
    public void deleteMerchandise(String merchandiseCode, String siteCode) throws SQLException {

    }

    @Override
    public void editMerchandise(String merchandiseCode, String siteCode, int merchandiseQuantity) throws SQLException {

    }

    @Override
    public List<Merchandise> getMerchandiseList(String siteCode) throws SQLException {
        return null;
    }

    @Override
    public List<Site> getSiteList(String merchandiseCode) throws SQLException {

    }


}
