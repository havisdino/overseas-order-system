package model;
import model.database.OOPDepartmentDatabase;
import model.database.SQLiteOOPDeptDatabase;
import model.database.SiteDatabase;

import java.util.List;

public class OOPDepartment {
    String id;
    private List<Order> orderList;
    private OOPDepartmentDatabase oopDepartmentDatabase;
    private SiteDatabase siteDatabase;

    public OOPDepartment(String id) throws Exception {
        this.id = id;
        oopDepartmentDatabase = new SQLiteOOPDeptDatabase();
    }

    public List<Order> getOrderList() {
        try {
            return oopDepartmentDatabase.getOrderList(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SiteInfo> getSiteInfo(String mercode) {
        try {
            return oopDepartmentDatabase.getSiteInfo(mercode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SiteInfo> filterSiteInfo(String deliveryDate, List<SiteInfo> siteInfoList) {
        try {
            return oopDepartmentDatabase.filterSiteInfo(deliveryDate, siteInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}