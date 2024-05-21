package frontend.controllers.oopdept;

import backend.Order;
import frontend.controllers.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CancelledOrderTagController extends Switchable {

    @FXML
    private Label dateLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    private Label salesDeptIDLabel;

    @FXML
    void finishButtonClicked(ActionEvent event) {

    }

    @FXML
    void reviewButtonClicked(ActionEvent event) throws Exception {
        jump("/frontend/fxml/oopdept/OrderHandlingScreen.fxml");
    }

    public void setData(Order order) {
        orderIDLabel.setText(order.getId());
        salesDeptIDLabel.setText(order.getSalesDeptID());
        dateLabel.setText(order.getDateCreate().toString());
    }

}
