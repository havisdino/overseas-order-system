package backend.database;

import backend.Config;
import backend.Merchandise;
import backend.Order;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
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
    public void createOrder(Order order) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        Statement stmt1 = connection.createStatement();

        String id = order.getId();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String dateCreate = dateFormat.format(new Date());
        String description = order.getDescription();
        String salesDepartmentID = order.getSalesDeptID();
        String oopDeptID = order.getOopDeptID();
        for (Merchandise md: order.getMerchandiseList()) {
            System.out.println(md.getCode());
            System.out.println(md.getName());
            System.out.println(md.getQuantity());
        }

        String query = "insert into order_ (id, salesdeptid, datecreated, description, oopdeptid) values ('" +
                id + "','" + salesDepartmentID + "','" + dateCreate + "','" +  description + "','" + oopDeptID + "')";
        stmt.executeUpdate(query);

        for (Merchandise md: order.getMerchandiseList()) {
            String query1 = "insert into (orderid, mercode) values ('" + order.getId() + "','" + md.getCode() + "')";
            stmt1.executeUpdate(query1);
        }

        stmt1.close();
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
        Statement stmt2 = connection.createStatement();
        Statement stmt3 = connection.createStatement();

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
            ResultSet mercodes = stmt2.executeQuery(query);
            List<Merchandise> merchandiseList = new ArrayList<>();

            while (mercodes.next()) {
                String merchandiseCode = results.getString("code");

                String query1 = "select name, unit, quantity, deliverydate from merchandise where code ='" + merchandiseCode + "'";
                ResultSet merchandiseInfo = stmt3.executeQuery(query1);
                String name = merchandiseInfo.getString("name");
                String unit = merchandiseInfo.getString("unit");
                int quantity = merchandiseInfo.getInt("quantity");

                String pattern1 = "yyyy-MM-dd";
                SimpleDateFormat dateFormat1 = new SimpleDateFormat(pattern1);

                String deliverydate = merchandiseInfo.getString("deliverydate");

                Date deliveryDate = null;
                try {
                    deliveryDate = dateFormat1.parse(deliverydate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Merchandise merchandiseObj = new Merchandise(merchandiseCode , name, unit, quantity, deliveryDate);
                merchandiseList.add(merchandiseObj);
            }

            Order orderObj = new Order(orderID, merchandiseList, dateCreate, description);
            orderList.add(orderObj);
        }

        stmt3.close();
        stmt2.close();
        stmt.close();
        close();
        return orderList;
    }

    @Override
    public List<String> getOOPDeptIDs() throws SQLException{
        connect();
        Statement stmt = connection.createStatement();
        String query = "select id from oopdept";
        ResultSet results = stmt.executeQuery(query);
        List<String> oopDeptIDList = new ArrayList<>();

        while(results.next()) {
            String oopDeptID = results.getString("id");
            oopDeptIDList.add(oopDeptID);
        }
        stmt.close();
        close();
        return oopDeptIDList;
    }
}
