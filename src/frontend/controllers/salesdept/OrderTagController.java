package frontend.controllers.salesdept;

import backend.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class OrderTagController {

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label desiredDateLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    void cancelButtonClicked(ActionEvent event) {

    }

    @FXML
    void detailButtonClicked(MouseEvent event) {

    }

    public void setData(Order order) {
        descriptionLabel.setText(order.getDescription());
        orderIDLabel.setText(order.getId());
        desiredDateLabel.setText(order.getDateCreate().toString());
    }

}
