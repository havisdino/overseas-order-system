package controller.oopdept.orderhandling;

import model.dataholder.Order;
import controller.Switchable;
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
        OrderHandlingController ohController = (OrderHandlingController) jump("/view/fxml/oopdept/orderhandling/OrderHandlingScreen.fxml");
        ohController.setData(order);
    }

    public void setData(Order order) {
        orderIDLabel.setText(order.getId());
        salesDeptIDLabel.setText(order.getSalesDeptID());
        dateLabel.setText(order.getDateCreatedInString());
        this.order = order;
    }
}
