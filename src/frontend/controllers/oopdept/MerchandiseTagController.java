package frontend.controllers.oopdept;

import backend.Merchandise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MerchandiseTagController {

    @FXML
    private Label mercodeLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label unitLabel;

    @FXML
    void searchButtonClicked(ActionEvent event) {

    }

    public void setData(Merchandise m) {
        mercodeLabel.setText(m.getCode());
        nameLabel.setText(m.getName());
        quantityLabel.setText(String.valueOf(m.getQuantity()));
        unitLabel.setText(m.getUnit());
    }
}