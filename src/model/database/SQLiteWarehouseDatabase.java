package model.database;

import model.Config;
import model.Merchandise;
import model.Order;
import model.OrderCheck;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SQLiteWarehouseDatabase implements WarehouseDatabase {
    private Connection connection;
    private String url;

    public SQLiteWarehouseDatabase() throws Exception {
        String dbPath = Config.getInstance().getDbPath();
        url = "jdbc:sqlite:" + dbPath;
    }

    @Override
    public void createOrderCheck(OrderCheck orderCheck) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        Statement stmt1 = connection.createStatement();
        String query = String.format(
                "insert into ordercheck (id, result, datecreated, warehouseid ) values ('%s', '%s', '%s', '%s')",
                orderCheck.getId(),
                orderCheck.getStatus(),
                orderCheck.getDateCreatedInString(),
                orderCheck.getWarehouseID()
        );
        stmt.executeUpdate(query);

        for (Merchandise md: orderCheck.getMerchandiseList()) {
            String query1 = "insert into ordercheck_merchandise(ordercheckid, mercode) values ('" + orderCheck.getId() + "','" + md.getCode() + "')";
            stmt1.executeUpdate(query1);
        }

        stmt1.close();
        stmt.close();
        close();
    }

    @Override
    public Order getOrder(String orderID) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        Statement stmt1 = connection.createStatement();

        String query = "select mercode, name, unit, quantity, deliverydate from order_merchandise where orderid = '" + orderID + "'";
        ResultSet mercodes = stmt.executeQuery(query);
        List<Merchandise> merchandiseList = new ArrayList<>();

        while (mercodes.next()) {
            String merchandiseCode = mercodes.getString("mercode");
            String name = mercodes.getString("name");
            String unit = mercodes.getString("unit");
            int quantity = mercodes.getInt("quantity");
            String deliverydate = mercodes.getString("deliverydate");

            String pattern1 = "yyyy-MM-dd";
            SimpleDateFormat dateFormat1 = new SimpleDateFormat(pattern1);

            Date deliveryDate = null;
            try {
                deliveryDate = dateFormat1.parse(deliverydate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            merchandiseList.add(new Merchandise(merchandiseCode , name, unit, quantity, deliveryDate));
        }

        String query1 = "select datecreated, description, salesdeptid, oopdeptid from order_ where id = '" + orderID + "'";
        ResultSet orders = stmt1.executeQuery(query1);
        Order orderObj = null;
        while (orders.next()) {
            String datecreate =  orders.getString("datecreated");
            String description =  orders.getString("description");
            String salesdeptid = orders.getString("salesdeptid");
            String oopdeptid = orders.getString("oopdeptid");
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

            Date dateCreate = null;
            try {
                dateCreate = dateFormat.parse(datecreate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            orderObj = new Order(orderID, merchandiseList, dateCreate, description, salesdeptid);
        }

        stmt1.close();
        stmt.close();
        close();
        return orderObj;
    }
    @Override
    public List<Order> getOrderList(String salesDepartmentID) throws SQLException {
        return null;
    }

    @Override
    public List<OrderCheck> getOrderCheckList(String warehouseID) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        String query = "select id, datecreated, result from ordercheck where warehouseid = '" + warehouseID + "'";
        ResultSet results = stmt.executeQuery(query);

        List<OrderCheck> orderCheckList = new ArrayList<>();

        while (results.next()) {
            String orderCheckId = results.getString("id");
            String result = results.getString("result");
            String datecreated = results.getString("datecreated");

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

            Date dateCreate = null;
            try {
                dateCreate = dateFormat.parse(datecreated);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            orderCheckList.add(new OrderCheck(orderCheckId, null, dateCreate, result));
        }

        stmt.close();
        close();
        return orderCheckList;
    }

    @Override
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url);
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
