package backend.database;

import backend.Merchandise;
import backend.Order;
import org.sqlite.SQLiteConnection;
import java.text.DateFormat;

import java.sql.*;
import java.text.SimpleDateFormat;
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
        long millis = System.currentTimeMillis();
        Date dateCreate = new Date(millis);
        String query = "insert into order_ (id, salesdeptid, dateCreate) values (" +
                id + "," + salesDepartmentID + ")" ;
        stmt.executeUpdate(query);
        stmt.close();
    }

    @Override
    public List<Order> getOrderList(String salesDepartmentID) throws SQLException {
        Statement stmt = connection.createStatement();

        String query = "select id, dateCreate from order_ where salesdeptid =" + salesDepartmentID;
        ResultSet results = stmt.executeQuery(query);

        List<Order> orderList = new ArrayList<>();
        while (results.next()) {
            String orderID = results.getString("id");
            Date dateCreate = results.getDate("dateCreate");

            query = "select mercode from order_merchandise where orderid =" + orderID;
            ResultSet mercodes = stmt.executeQuery(query);
            List<Merchandise> merchandiseList = new ArrayList<>();

            while (mercodes.next()) {
                String merchandiseCode = results.getString("code");

                String query1 = "select name, unit, quantity, deliveryDate from merchandise where code =" + merchandiseCode;
                ResultSet merchandiseInfo = stmt.executeQuery(query1);
                String name = merchandiseInfo.getString("name");
                String unit = merchandiseInfo.getString("unit");
                int quantity = merchandiseInfo.getInt("quantity");
                Date deliveryDate = merchandiseInfo.getDate("deliveryDate");
                Merchandise merchandiseObj = new Merchandise(merchandiseCode , name, unit, quantity, deliveryDate);
                merchandiseList.add(merchandiseObj);
            }

            Order orderObj = new Order(orderID, merchandiseList, dateCreate);
            orderList.add(orderObj);
        }

        stmt.executeUpdate(query);
        stmt.close();
        return orderList;
    }
}
