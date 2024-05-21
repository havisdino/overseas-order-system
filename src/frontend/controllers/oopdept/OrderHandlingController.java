package frontend.controllers.oopdept;

import backend.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OrderHandlingController {

    private Order order;

    @FXML
    private Label desiredDateLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    private Label salesDepartmentIDLabel;

    @FXML
    void cancelButtonClicked(ActionEvent event) {

    }

    @FXML
    void placeButtonClicked(ActionEvent event) {

    }

    public void setData(Order order) {
        this.order = order;
        orderIDLabel.setText(order.getId());
        salesDepartmentIDLabel.setText(order.getSalesDeptID());
        desiredDateLabel.setText(order.getDateCreate().toString());
    }

}
