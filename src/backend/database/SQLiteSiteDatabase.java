package backend.database;

import backend.Merchandise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteSiteDatabase implements SiteDatabase {
    private Connection connection;

    public SQLiteSiteDatabase(String dbPath) throws Exception {
        String url = "jdbc:sqlite:" + dbPath;
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public void addMerchandise(String merchandiseCode, String siteCode, int quantity) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = "insert into site_merchandise (siteCode, merchandiseCode, quantity) values (" +
                siteCode + "," + merchandiseCode + "," + quantity + ")";
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
        Statement stmt = connection.createStatement();

        String query = "select merchandiseCode, quantity from site_merchandise where siteCode = " + siteCode;
        ResultSet results = stmt.executeQuery(query);

        List<Merchandise> merchandiseList = new ArrayList<>();
        while (results.next()) {
            String merchandiseCode = results.getString("merchandiseCode");
            int merchandiseQuantity = results.getInt("quantity");
            query = "select name, unit from rawmerchandise where code = " + merchandiseCode;
            ResultSet merchandiseInfo = stmt.executeQuery(query);
            String merchandiseName = merchandiseInfo.getString("name");
            String merchandiseUnit = merchandiseInfo.getString("unit");
            merchandiseList.add(new Merchandise(merchandiseCode, merchandiseName, merchandiseUnit, merchandiseQuantity));
        }

        return merchandiseList;
    }
}
