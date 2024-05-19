package backend.database;

import backend.Merchandise;
import backend.Order;
import org.sqlite.SQLiteConnection;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SQLiteSalesDeptDatabase implements SalesDepartmentDatabase {
    private Connection connection;

    public SQLiteSalesDeptDatabase(String dbPath) throws Exception {
        String url = "jdbc:sqlite:" + dbPath;
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public void createOrder(Order order, String salesDepartmentID) throws SQLException {
        Statement stmt = connection.createStatement();
        String id = String.valueOf(Instant.now().getEpochSecond());
        String query = "insert into order (id, salesdeptid) values (" +
                id + "," + salesDepartmentID + ")" ;
        stmt.executeUpdate(query);
        stmt.close();
    }

    @Override
    public List<Order> getOrderList(String salesDepartmentID) throws SQLException {
        Statement stmt = connection.createStatement();

        String query = "select id from order where salesdeptid =" + salesDepartmentID;
        ResultSet results = stmt.executeQuery(query);

        while (results.next()) {
            String orderID = results.getString("id");

            query = "select mercode from order_merchandise where orderid =" + orderID;
            ResultSet mercodes = stmt.executeQuery(query);
            List<Merchandise> merchandiseList = new ArrayList<>();

            while (mercodes.next()) {
                //
            }

        }


        stmt.executeUpdate(query);
        stmt.close();
        return null;
    }
}
