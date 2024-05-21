package frontend.controllers.salesdept;

import backend.Merchandise;
import backend.RawMerchandise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Date;
import java.util.List;

public class MerTagController {
    List<Merchandise> cart;

    @FXML
    private Button addButton;

    @FXML
    private TextField dateField;

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
        Merchandise merchandise = new Merchandise(
                mercodeLabel.getText(),
                nameLabel.getText(),
                unitLabel.getText(),
                quantity,
//                dateField.getText()
                new Date()
        );
        cart.add(merchandise);
        disableButton(addButton);
        System.out.println(cart);
    }

    private void disableButton(Button button) {
        button.setDisable(true);
        button.setStyle("-fx-text-fill: -color-base-4");
    }

    public void setData(RawMerchandise m) {
        mercodeLabel.setText(m.getCode());
        nameLabel.setText(m.getName());
        unitLabel.setText(m.getUnit());
    }

    public void setCart(List<Merchandise> cart) {
        this.cart = cart;
    }
}
