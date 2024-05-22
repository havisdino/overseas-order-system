package model.database;

import model.Config;
import model.RawMerchandise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteRawMerchandiseDatabase implements RawMerchandiseDatabase {
    private Connection connection;
    private String url;

    public SQLiteRawMerchandiseDatabase() throws Exception {
        String dbPath = Config.getInstance().getDbPath();
        url = "jdbc:sqlite:" + dbPath;
    }
    @Override
    public RawMerchandise findRawMerchandise(String merchandiseCode) {
        return null;
    }

    @Override
    public List<RawMerchandise> getMerchandises() throws SQLException {
        connect();
        Statement stmt = connection.createStatement();

        String query = "select * from rawmerchandise";
        ResultSet results = stmt.executeQuery(query);

        List<RawMerchandise> merchandiseList = new ArrayList<>();
        while (results.next()) {
            String code = results.getString("code");
            String name = results.getString("name");
            String unit = results.getString("unit");
            merchandiseList.add(new RawMerchandise(code, name, unit));
        }
        stmt.close();
        close();
        return merchandiseList;
    }

    public List<RawMerchandise> getMerchandisesExceptSite(String siteCode) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();

        String query = "select * from rawmerchandise where code not in (select mercode from site_merchandise where sitecode = '" + siteCode + "')";
        ResultSet results = stmt.executeQuery(query);

        List<RawMerchandise> merchandiseList = new ArrayList<>();
        while (results.next()) {
            String code = results.getString("code");
            String name = results.getString("name");
            String unit = results.getString("unit");
            merchandiseList.add(new RawMerchandise(code, name, unit));
        }
        stmt.close();
        close();
        return merchandiseList;
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
