package frontend.controllers.oopdept;

import backend.Merchandise;
import backend.Order;
import frontend.controllers.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SiteInfoController extends Switchable {
    private Order order;
    private Merchandise merchandise;

    @FXML
    private Label desiredDateLabel;

    @FXML
    private Label mercodeLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    private Label salesDeptIDLabel;

    @FXML
    void cancelButtonClicked(ActionEvent event) {
        close(event);
    }

    public void setData(Merchandise m, Order o) {
        desiredDateLabel.setText(o.getDateCreatedInString());
        orderIDLabel.setText(o.getId());
        salesDeptIDLabel.setText(o.getSalesDeptID());
        mercodeLabel.setText(m.getCode());
        merchandise = m;
        order = o;
    }

}