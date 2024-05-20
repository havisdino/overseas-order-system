package backend.database;

import backend.DeliveryInfo;
import backend.Merchandise;
import backend.Site;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteSiteDatabase implements SiteDatabase {
    private Connection connection;
    private String name;
    private DeliveryInfo deliveryInfo;
    private String otherInfo;


    public SQLiteSiteDatabase(String dbPath) throws Exception {
        String url = "jdbc:sqlite:" + dbPath;
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public void addMerchandise(String merchandiseCode, String siteCode, int quantity) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = "insert into site_merchandise (sitecode, mercode, quantity) values ('" +
                siteCode + "','" + merchandiseCode + "','" + quantity + "')";
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

        String query = "select mercode, quantity from site_merchandise where sitecode = '" + siteCode + "'";
        ResultSet results = stmt.executeQuery(query);

        List<Merchandise> merchandiseList = new ArrayList<>();
        while (results.next()) {
            String merchandiseCode = results.getString("mercode");
            int merchandiseQuantity = results.getInt("quantity");
            query = "select name, unit from rawmerchandise where code = '" + merchandiseCode + "'";
            ResultSet merchandiseInfo = stmt.executeQuery(query);
            String merchandiseName = merchandiseInfo.getString("name");
            String merchandiseUnit = merchandiseInfo.getString("unit");
            merchandiseList.add(new Merchandise(merchandiseCode, merchandiseName, merchandiseUnit, merchandiseQuantity));
        }

        return merchandiseList;
    }

<<<<<<< HEAD
=======
    @Override
    public void loadSiteInfo(String siteCode) throws SQLException {
        Statement stmt = connection.createStatement();

        String query = "select name, daysByShip, daysByAir, otherInfo from site where code = '" + siteCode + "'";
        ResultSet results = stmt.executeQuery(query);

        String name = results.getString("name");
        int daysByShip = results.getInt("daysByShip");
        int daysByAir = results.getInt("daysByAir");
        String otherInfo = results.getString("otherInfo");

        this.name = name;
        this.deliveryInfo = new DeliveryInfo(daysByShip, daysByAir);
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public String getOtherInfo() {
        return otherInfo;
    }
>>>>>>> c212a3b472c0dca2625f3d2976e9f08717715484

}
