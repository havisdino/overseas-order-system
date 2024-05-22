package controller.site;

import model.Merchandise;
import model.RawMerchandise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class AddMerTagController {
    List<Merchandise> cart;
    RawMerchandise rawMerchandise;
    Merchandise merchandise;

    @FXML
    private Button addButton;

    @FXML
    private Label mercodeLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField quantityField;

    @FXML
    private Label unitLabel;

    @FXML
    void addButtonClicked(ActionEvent event) {
        int quantity = Integer.parseInt(quantityField.getText());
        merchandise = new Merchandise(
            rawMerchandise.getCode(),
            rawMerchandise.getName(),
            rawMerchandise.getUnit(),
            quantity
        );
        merchandise.setQuantity(quantity);
        cart.add(merchandise);
        disableButton(addButton);
    }

    private void disableButton(Button button) {
        button.setDisable(true);
        button.setStyle("-fx-text-fill: -color-base-4");
    }

    public void setCart(List<Merchandise> cart) {
        this.cart = cart;
    }

    public void setData(RawMerchandise merchandise) {
        mercodeLabel.setText(merchandise.getCode());
        nameLabel.setText(merchandise.getName());
        unitLabel.setText(merchandise.getUnit());

        rawMerchandise = merchandise;
    }

}
