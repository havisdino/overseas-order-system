package backend.database;

import backend.Config;
import backend.Merchandise;
import backend.Order;
import backend.Site;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SQLiteOOPDeptDatabase implements OOPDepartmentDatabase {
    private Connection connection;
    private String url;

    public SQLiteOOPDeptDatabase() throws Exception {
        String dbPath = Config.getInstance().getDbPath();
        url = "jdbc:sqlite:" + dbPath;
    }

    @Override
    public List<Order> getOrderList(String OOPDeptID) throws SQLException {
        Statement stmt = connection.createStatement();

        String query = "select order_.id, order_.dateCreate, order_.description from oopdept_order join order_ on oopdept_order.orderid = order_.id where oopdept_order.oopdeptid =" + OOPDeptID;
        ResultSet results = stmt.executeQuery(query);

        List<Order> orderList = new ArrayList<>();
        while (results.next()) {
            String orderID = results.getString("id");
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            String datecreate = results.getString("datecreated");
            Date dateCreate = null;
            try {
                dateCreate = dateFormat.parse(datecreate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String description = results.getString("description");

            query = "select merchandise.code, merchandise.name, merchandise.quantity, merchandise.deliverydate from order_merchandise join merchandise on order_merchandise.mercode = merchandise.code where orderid =" + orderID;
            ResultSet merchandises = stmt.executeQuery(query);
            List<Merchandise> merchandiseList = new ArrayList<>();

            while (merchandises.next()) {
                String merchandiseCode = merchandises.getString("code");
                String name = merchandises.getString("name");
                String unit = merchandises.getString("unit");
                int quantity = merchandises.getInt("quantity");
                String pattern1 = "yyyy-MM-dd";
                SimpleDateFormat dateFormat1 = new SimpleDateFormat(pattern1);
                String deliverydate = results.getString("deliverydate");
                Date deliveryDate = null;
                try {
                    deliveryDate = dateFormat.parse(deliverydate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Merchandise merchandiseObj = new Merchandise(merchandiseCode , name, unit, quantity, deliveryDate);
                merchandiseList.add(merchandiseObj);
            }

            Order orderObj = new Order(orderID, merchandiseList, dateCreate, description);
            orderList.add(orderObj);
        }

        stmt.executeUpdate(query);
        stmt.close();
        return orderList;
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
    public void stashOrder(String orderID) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        String query = "insert into stashedorder (orderid) values ('" + orderID + "')";
        stmt.executeUpdate(query);
        stmt.close();
        close();
    }

    @Override
    public void removeStashedOrder(String orderID) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        String query = "delete from stashedorder where orderid = '" + orderID + "'";
        stmt.executeUpdate(query);
        stmt.close();
        close();
    }

    @Override
    public void addCancelledOrder(String orderID) {

    }
}
