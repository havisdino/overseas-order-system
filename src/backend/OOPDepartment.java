package backend;
import backend.database.OOPDepartmentDatabase;
import backend.database.SQLiteOOPDeptDatabase;
import backend.database.SiteDatabase;

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

    public OOPDepartment(String id) {
        this.id = id;
    }

    public List<Order> getOrderList() {
        try {
            return oopDepartmentDatabase.getOrderList(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Site> getSites() {
//        try {
//            return siteDatabase.getSiteList();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
        return null;
    }
}
