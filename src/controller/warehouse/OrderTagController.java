package controller.warehouse;

import model.dataholder.OrderCheck;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OrderTagController {

    @FXML
    private Label checkResultLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label desiredDateLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    void detailButtonClicked(ActionEvent event) {

    }

    public void setData(OrderCheck orderCheck) {
        orderIDLabel.setText(orderCheck.getId());
        desiredDateLabel.setText(orderCheck.getDateCreatedInString());

        String checkResult = orderCheck.getStatus();
        checkResultLabel.setText(checkResult);
        if (checkResult.equals("Distinct")) {
            checkResultLabel.setStyle("-fx-text-fill: -color-danger-7");
        } else if (checkResult.equals("Identical")) {
            checkResultLabel.getStyleClass().add("success-text");
        }
    }

}
