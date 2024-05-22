package controller.oopdept.cancellation;

import model.Merchandise;
import model.Order;
import controller.Switchable;
import controller.oopdept.orderhandling.MerchandiseTagController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class OrderReviewController extends Switchable {
    private Order order;

    @FXML
    private Label dateLabel;

    @FXML
    private Label descLabel;

    @FXML
    private VBox mainVBox;

    @FXML
    private Label orderIDLabel;

    @FXML
    private Label salesDepartmentIDLabel;

    @FXML
    void backButtonClicked(ActionEvent event) {
        close(event);
    }

    @FXML
    void placeButtonClicked(ActionEvent event) {

    }

    public void setData(Order order) throws Exception {
        dateLabel.setText(order.getDateCreatedInString());
        descLabel.setText(order.getDescription());
        orderIDLabel.setText(order.getId());
        salesDepartmentIDLabel.setText(order.getSalesDeptID());
        this.order = order;
        addMerTags(order.getMerchandiseList());
    }

    private void addMerTags(List<Merchandise> mers) throws Exception {
        for (Merchandise m : mers) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/fxml/oopdept/orderhandling/MerchandiseTag.fxml"));
            HBox merTag = loader.load();
            MerchandiseTagController merTagController = loader.getController();

            merTagController.setData(m, order);
            mainVBox.getChildren().add(merTag);
        }
    }

}