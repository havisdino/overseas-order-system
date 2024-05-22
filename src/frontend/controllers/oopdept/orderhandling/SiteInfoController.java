package frontend.controllers.oopdept.orderhandling;

import backend.*;
import frontend.controllers.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SiteInfoController extends Switchable implements Initializable {
    private Order order;
    private Merchandise merchandise;
    private List<SiteTagController> siteTagControllers = new ArrayList<>();
    private int totalQuantity;
    private int selectedQuantity;
    private MerchandiseTagController merTagController;

    @FXML
    private Label descLabel;

    @FXML
    private VBox mainVBox;

    @FXML
    private Label desiredDateLabel;

    @FXML
    private Label mercodeLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    private Label salesDeptIDLabel;

    @FXML
    private Label selectedLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedLabel.setText(selectedQuantity + "/" + totalQuantity);
    }

    @FXML
    void cancelButtonClicked(ActionEvent event) {
        close(event);
    }

    @FXML
    void doneButtonClicked(ActionEvent event) {
        merTagController.setStatusLabel("Handled");
        close(event);
    }

    public void setData(Merchandise m, Order o) {
        desiredDateLabel.setText(o.getDateCreatedInString());
        orderIDLabel.setText(o.getId());
        salesDeptIDLabel.setText(o.getSalesDeptID());
        descLabel.setText(o.getDescription());
        mercodeLabel.setText(m.getCode());
        merchandise = m;
        order = o;

        totalQuantity = m.getQuantity();
        selectedLabel.setText(selectedQuantity + "/" + totalQuantity);

        try {
            OOPDepartment oopDept = new OOPDepartment(Config.getInstance().getUsername());
            List<SiteInfo> siteInfoList = oopDept.getSiteInfo(merchandise.getCode());
            addSiteTags(siteInfoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSiteTags(List<SiteInfo> siteInfoList) throws Exception {
        for (SiteInfo siteInfo : siteInfoList) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/frontend/fxml/oopdept/orderhandling/SiteTag.fxml"));
            HBox siteTag = loader.load();
            SiteTagController siteTagController = loader.getController();
            siteTagControllers.add(siteTagController);
            siteTagController.setData(siteInfo);
            siteTagController.setParentController(this);
            mainVBox.getChildren().add(siteTag);
        }
    }

    public void disableAdding() {
        for (SiteTagController c : siteTagControllers) {
            c.getAddButton().setDisable(true);
            c.getAddButton().setStyle("-fx-text-fill: -color-base-4");
        }
    }

    public void setSelectedQuantity(int n) {
        selectedQuantity = n;
        if (selectedQuantity >= totalQuantity) {
            disableAdding();
        }
        selectedLabel.setText(selectedQuantity + "/" + totalQuantity);
    }

    public void setParentController(MerchandiseTagController c) {
        merTagController = c;
    }
}