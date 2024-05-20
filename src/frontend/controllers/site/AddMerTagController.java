package frontend.controllers.site;

import backend.Merchandise;
import backend.RawMerchandise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class AddMerTagController {
    List<Merchandise> cart;
    RawMerchandise rawMerchandise;
    Merchandise merchandise;

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
        System.out.println(cart);
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
