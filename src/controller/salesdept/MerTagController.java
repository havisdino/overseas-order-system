package controller.salesdept;

import model.dataholder.Merchandise;
import model.dataholder.RawMerchandise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MerTagController {
    private List<Merchandise> cart;

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
        String dateString = dateField.getText();
        try {
            Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(dateString);
            Merchandise merchandise = new Merchandise(
                    mercodeLabel.getText(),
                    nameLabel.getText(),
                    unitLabel.getText(),
                    quantity,
                    date
            );
            cart.add(merchandise);
            disableButton(addButton);
            System.out.println(cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
