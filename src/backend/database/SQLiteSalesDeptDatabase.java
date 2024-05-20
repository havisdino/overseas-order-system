package backend.database;

import backend.Config;
import backend.Merchandise;
import backend.Order;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SQLiteSalesDeptDatabase implements SalesDepartmentDatabase {
    private Connection connection;
    private String url;

    public SQLiteSalesDeptDatabase() throws Exception {
        String dbPath = Config.getInstance().getDbPath();
        url = "jdbc:sqlite:" + dbPath;
    }

    @Override
    public void createOrder(Order order, String salesDepartmentID) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        String id = String.valueOf(Instant.now().getEpochSecond());
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String dateCreate = dateFormat.format(new Date());
        String description = order.getDescription();
        String query = "insert into order_ (id, salesdeptid, datecreated, description) values ('" +
                id + "','" + salesDepartmentID + "','" + dateCreate + "','" +  description + "')";
        stmt.executeUpdate(query);
        stmt.close();
        close();
    }

    @Override
    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

    @Override
    public List<Order> getOrderList(String salesDepartmentID) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();

        String query = "select id, datecreated, description from order_ where salesdeptid ='" + salesDepartmentID + "'";
        ResultSet results = stmt.executeQuery(query);

        List<Order> orderList = new ArrayList<>();
        while (results.next()) {
            String orderID = results.getString("id");
            String datecreate = results.getString("datecreated");
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

            Date dateCreate = null;
            try {
                 dateCreate = dateFormat.parse(datecreate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String description = results.getString("description");

            query = "select mercode from order_merchandise where orderid ='" + orderID + "'";
            ResultSet mercodes = stmt.executeQuery(query);
            List<Merchandise> merchandiseList = new ArrayList<>();

            while (mercodes.next()) {
                String merchandiseCode = results.getString("code");

                String query1 = "select name, unit, quantity, deliverydate from merchandise where code ='" + merchandiseCode + "'";
                ResultSet merchandiseInfo = stmt.executeQuery(query1);
                String name = merchandiseInfo.getString("name");
                String unit = merchandiseInfo.getString("unit");
                int quantity = merchandiseInfo.getInt("quantity");
                Date deliveryDate = merchandiseInfo.getDate("deliverydate");
                Merchandise merchandiseObj = new Merchandise(merchandiseCode , name, unit, quantity, deliveryDate);
                merchandiseList.add(merchandiseObj);
            }

            Order orderObj = new Order(orderID, merchandiseList, dateCreate, description);
            orderList.add(orderObj);
        }

        stmt.executeUpdate(query);
        stmt.close();
        close();
        return orderList;
    }
}
