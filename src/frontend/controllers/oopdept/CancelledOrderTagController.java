package frontend.controllers.oopdept;

import backend.CancellationHandler;
import backend.Config;
import backend.Order;
import frontend.controllers.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CancelledOrderTagController extends Switchable {
    private Order order;

    @FXML
    private Label dateLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    private Label salesDeptIDLabel;

    @FXML
    void cancelButtonClicked(ActionEvent event) throws Exception {
        CancellationHandler ch = new CancellationHandler(Config.getInstance().getUsername());
        ch.addCancelledOrder(order.getId());
        ch.removeStashedOrder(order.getId());
        close(event);
    }

    @FXML
    void reviewButtonClicked(ActionEvent event) throws Exception {
        OrderHandlingController ohc = (OrderHandlingController) jump("/frontend/fxml/oopdept/OrderHandlingScreen.fxml");
        ohc.setData(order);
    }

    public void setData(Order order) {
        this.order = order;
        orderIDLabel.setText(order.getId());
        salesDeptIDLabel.setText(order.getSalesDeptID());
        dateLabel.setText(order.getDateCreate().toString());
    }
}
