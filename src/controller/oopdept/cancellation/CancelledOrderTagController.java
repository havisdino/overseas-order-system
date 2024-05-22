package controller.oopdept.cancellation;

import model.CancellationHandler;
import model.Config;
import model.Order;
import controller.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CancelledOrderTagController extends Switchable {
    private Order order;

    @FXML
    private HBox buttonContainer;

    @FXML
    private Label dateLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    private Label salesDeptIDLabel;

    @FXML
    void cancelButtonClicked(ActionEvent event) throws Exception {
        ConfirmScreenController c = (ConfirmScreenController) jump("/view/fxml/oopdept/cancellation/ConfirmScreen.fxml");
        c.setParentController(this);
    }

    public void confirmCancel(String note) throws Exception {
        CancellationHandler ch = new CancellationHandler(Config.getInstance().getUsername());
        ch.addCancelledOrder(order.getId(), note);
        ch.removeStashedOrder(order.getId());
        buttonContainer.getChildren().clear();
        Label cancelledLabel = new Label();
        cancelledLabel.setText("Cancelled");
        cancelledLabel.getStyleClass().add("normal-text");
        cancelledLabel.setStyle("-fx-text-fill: -color-base-4");
        buttonContainer.getChildren().add(cancelledLabel);
    }

    @FXML
    void reviewButtonClicked(ActionEvent event) throws Exception {
        OrderReviewController ohc = (OrderReviewController) jump("/view/fxml/oopdept/cancellation/OrderReviewScreen.fxml");
        ohc.setData(order);
    }

    public void setData(Order order) {
        this.order = order;
        orderIDLabel.setText(order.getId());
        salesDeptIDLabel.setText(order.getSalesDeptID());
        dateLabel.setText(order.getDateCreatedInString());
    }
}
