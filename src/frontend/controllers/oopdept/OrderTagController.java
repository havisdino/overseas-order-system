package frontend.controllers.oopdept;

import backend.Order;
import frontend.controllers.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OrderTagController extends Switchable {
    private Order order;

    @FXML
    private Label dateLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    private Label salesDeptIDLabel;

    @FXML
    void handleButtonClicked(ActionEvent event) throws Exception {
        OrderHandlingController ohController = (OrderHandlingController) jump("/frontend/fxml/oopdept/OrderHandlingScreen.fxml");
        ohController.setData(order);
    }

    public void setData(Order order) {
        orderIDLabel.setText(order.getId());
        salesDeptIDLabel.setText(order.getSalesDeptID());
        dateLabel.setText(order.getDateCreatedInString());
        this.order = order;
    }
}
