package backend.database;

import backend.*;

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
        connect();
        Statement stmt = connection.createStatement();
        Statement stmt2 = connection.createStatement();
        Statement stmt3 = connection.createStatement();

        String query = "select id, datecreated, description, salesdeptid " +
                "from order_ " +
                "where oopdeptid = '" + OOPDeptID + "' " +
                "and id not in ( " +
                "select orderid as id " +
                "from stashedorder" +
                ");";
        ResultSet results = stmt.executeQuery(query);

        List<Order> orderList = new ArrayList<>();
        while (results.next()) {
            String orderID = results.getString("id");
            String datecreate = results.getString("datecreated");
            String salesDeptID = results.getString("salesdeptid");
            String description = results.getString("description");

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

            Date dateCreate = null;
            try {
                dateCreate = dateFormat.parse(datecreate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String query1 = "select mercode, name, unit, quantity, deliverydate from order_merchandise where orderid ='" + orderID + "'";
            ResultSet mercodes = stmt2.executeQuery(query1);
            List<Merchandise> merchandiseList = new ArrayList<>();

            while (mercodes.next()) {
                String merchandiseCode = mercodes.getString("mercode");
                String name = mercodes.getString("name");
                String unit = mercodes.getString("unit");
                int quantity = mercodes.getInt("quantity");

                String pattern1 = "yyyy-MM-dd";
                SimpleDateFormat dateFormat1 = new SimpleDateFormat(pattern1);

                String deliverydate = mercodes.getString("deliverydate");

                Date deliveryDate = null;
                try {
                    deliveryDate = dateFormat1.parse(deliverydate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Merchandise merchandiseObj = new Merchandise(merchandiseCode , name, unit, quantity, deliveryDate);
                merchandiseList.add(merchandiseObj);
            }

            Order orderObj = new Order(orderID, merchandiseList, dateCreate, description, salesDeptID);
            orderList.add(orderObj);
        }
        stmt2.close();
        stmt.close();
        close();
        return orderList;
    }

//    public List<Order> getOrderList(String OOPDeptID) throws SQLException {
//        connect();
//        Statement stmt = connection.createStatement();
//        Statement stmt2 = connection.createStatement();
//        Statement stmt3 = connection.createStatement();
//
//        String query = "select id, datecreated, description, salesdeptid from order_ where oopdeptid ='" + OOPDeptID + "'";
//        ResultSet results = stmt.executeQuery(query);
//
//        List<Order> orderList = new ArrayList<>();
//        while (results.next()) {
//            String orderID = results.getString("id");
//            String datecreate = results.getString("datecreated");
//            String salesDeptID = results.getString("salesdeptid");
//            String description = results.getString("description");
//
//            String pattern = "yyyy-MM-dd";
//            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
//
//            Date dateCreate = null;
//            try {
//                dateCreate = dateFormat.parse(datecreate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//            String query1 = "select mercode from order_merchandise where orderid ='" + orderID + "'";
//            ResultSet mercodes = stmt2.executeQuery(query1);
//            List<Merchandise> merchandiseList = new ArrayList<>();
//
//            while (mercodes.next()) {
//                String merchandiseCode = mercodes.getString("mercode");
//                String query2 = "select name, unit, quantity, deliverydate from merchandise where code ='" + merchandiseCode + "'";
//                ResultSet merchandiseInfo = stmt3.executeQuery(query2);
//                String name = merchandiseInfo.getString("name");
//                System.out.println(name);
//                String unit = merchandiseInfo.getString("unit");
//                System.out.println(unit);
//                int quantity = merchandiseInfo.getInt("quantity");
//
//                String pattern1 = "yyyy-MM-dd";
//                SimpleDateFormat dateFormat1 = new SimpleDateFormat(pattern1);
//
//                String deliverydate = merchandiseInfo.getString("deliverydate");
//
//                Date deliveryDate = null;
//                try {
//                    deliveryDate = dateFormat1.parse(deliverydate);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                Merchandise merchandiseObj = new Merchandise(merchandiseCode , name, unit, quantity, deliveryDate);
//                merchandiseList.add(merchandiseObj);
//            }
//
//            Order orderObj = new Order(orderID, merchandiseList, dateCreate, description, salesDeptID);
//            orderList.add(orderObj);
//        }
//
//        stmt3.close();
//        stmt2.close();
//        stmt.close();
//        close();
//        return orderList;
//    }

    public List<SiteInfo> getSiteInfo(String merchandiseCode) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        String query = "select site.code, site.name, site_merchandise.quantity from site join site_merchandise on site.code = site_merchandise.sitecode where site_merchandise.mercode ='" + merchandiseCode + "'";
        ResultSet results = stmt.executeQuery(query);

        List<SiteInfo> siteInfoList = new ArrayList<>();

        while(results.next()) {
            String siteCode = results.getString("code");
            String name = results.getString("name");
            int quantity = results.getInt("quantity");
            siteInfoList.add(new SiteInfo(siteCode, name, quantity));
        }

        stmt.close();
        close();
        return siteInfoList;
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
    public void addStashedOrder(String orderID) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        String query = "insert into stashedorder (orderid) values ('" + orderID + "')";
        System.out.println("Order " + orderID + " stashed");
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

    @Override
    public List<Order> getStashedOrders(String oopdDeptID) throws SQLException {
        connect();
        Statement stmt = connection.createStatement();
        String query = "select orderid, salesdeptid, oopdeptid, datecreated, description " +
                "from stashedorder as so join order_ as o " +
                "on so.orderid = o.id " +
                "where oopdeptid = '" + oopdDeptID + "'";

        ResultSet res = stmt.executeQuery(query);

        List<Order> orders = new ArrayList<>();
        while (res.next()) {
            String orderID = res.getString("orderid");
            String salesDeptId  = res.getString("salesdeptid");
            String desc = res.getString("description");
            String dateString = res.getString("datecreated");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = dateFormat.parse(dateString);
                List<Merchandise> mers = getMerList(orderID);
                orders.add(new Order(orderID, mers, date, desc, salesDeptId));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        stmt.close();
        close();
        return orders;
    }

    private List<Merchandise> getMerList(String orderID) throws Exception {
        List<Merchandise> mers = new ArrayList<>();
        Statement stmt = connection.createStatement();
        String query = "select mercode, name, unit, quantity, deliverydate " +
                "from order_merchandise where orderid = '" + orderID + "'";
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            String code = res.getString("mercode");
            String name = res.getString("name");
            String unit = res.getString("unit");
            int quantity = res.getInt("quantity");
            String dateString = res.getString("deliverydate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = dateFormat.parse(dateString);
                mers.add(new Merchandise(code, name, unit, quantity, date));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stmt.close();

        return mers;
    }
}
