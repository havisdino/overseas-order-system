package controller.oopdept.orderhandling;

import model.dataholder.Merchandise;
import model.dataholder.Order;
import controller.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MerchandiseTagController extends Switchable {
    private Merchandise merchandise;
    private Order order;

    @FXML
    private Label mercodeLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label unitLabel;

    @FXML
    void searchButtonClicked(ActionEvent event) throws Exception {
        SiteInfoController siteInfoController = (SiteInfoController) jump("/view/fxml/oopdept/orderhandling/SiteInfoScreen.fxml");
        siteInfoController.setData(merchandise, order);
        siteInfoController.setParentController(this);
    }

    public void setData(Merchandise m, Order o) {
        order = o;
        merchandise = m;
        mercodeLabel.setText(m.getCode());
        nameLabel.setText(m.getName());
        quantityLabel.setText(String.valueOf(m.getQuantity()));
        unitLabel.setText(m.getUnit());
    }

    public void setStatusLabel(String status) {
        statusLabel.setText(status);
        statusLabel.getStyleClass().removeLast();
        if (status.equals("Handled")) {
            statusLabel.getStyleClass().add("success-text");
        } else {
            statusLabel.getStyleClass().add("failed-text");
        }
    }
}