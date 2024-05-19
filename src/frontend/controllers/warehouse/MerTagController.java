package frontend.controllers.warehouse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MerTagController {

    @FXML
    private Label mercodeLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField quantityField;

    @FXML
    private Label unitLabel;

    @FXML
    private Button addButton;

    @FXML
    void addButtonClicked(ActionEvent event) {
        addButton.setVisible(false);
    }

    void setData(String merchandiseCode, String name, String unit) {
        mercodeLabel.setText(merchandiseCode);
        nameLabel.setText(name);
        unitLabel.setText(unit);
    }

    int getQuantity() {
        String qS = quantityField.getText();
        return Integer.parseInt(qS);
    }
}
