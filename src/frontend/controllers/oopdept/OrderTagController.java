package frontend.controllers.oopdept;

import backend.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OrderTagController {

    @FXML
    private Label dateLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    private Label salesDeptIDLabel;

    @FXML
    void handleButtonClicked(ActionEvent event) {

    }

    public void setData(Order order) {
        orderIDLabel.setText(order.getId());
        salesDeptIDLabel.setText(order.getSalesDeptID());
        dateLabel.setText(order.getDateCreate().toString());
    }
}
