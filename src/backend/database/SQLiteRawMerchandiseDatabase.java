package backend.database;

import backend.RawMerchandise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteRawMerchandiseDatabase implements RawMerchandiseDatabase {
    private Connection connection;

    public SQLiteRawMerchandiseDatabase(String dbPath) throws Exception {
        String url = "jdbc:sqlite:" + dbPath;
        this.connection = DriverManager.getConnection(url);
    }
    @Override
    public RawMerchandise findRawMerchandise(String merchandiseCode) {
        return null;
    }

    @Override
    public List<RawMerchandise> getMerchandises() throws SQLException {
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
        return merchandiseList;
    }
}
