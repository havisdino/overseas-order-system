package backend.database;

import backend.Config;
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
    private String url;


    public SQLiteSiteDatabase() throws Exception {
        String dbPath = Config.getInstance().getDbPath();
        url = "jdbc:sqlite:" + dbPath;
    }

    @Override
    public void addMerchandise(String merchandiseCode, String siteCode, int quantity) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        String query = "insert into site_merchandise (sitecode, mercode, quantity) values ('" +
                siteCode + "','" + merchandiseCode + "','" + quantity + "')";
        stmt.executeUpdate(query);
        stmt.close();
        close();
    }

    @Override
    public List<Merchandise> getMerchandiseList(String siteCode) throws SQLException {
        connect();
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

        stmt.close();
        close();
        return merchandiseList;
    }
    @Override
    public void loadSiteInfo(String siteCode) throws SQLException {
        connect();
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

        stmt.close();
        close();
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

    @Override
    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}