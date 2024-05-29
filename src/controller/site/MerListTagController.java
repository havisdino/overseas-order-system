package controller.site;

import model.dataholder.Merchandise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MerListTagController {

    @FXML
    private Label mercodeLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label unitLabel;

    @FXML
    void deleteButtonClicked(ActionEvent event) {

    }

    @FXML
    void editButtonClicked(ActionEvent event) {

    }

    public void setData(Merchandise merchandise) {
        mercodeLabel.setText(merchandise.getCode());
        nameLabel.setText(merchandise.getName());
        quantityLabel.setText(String.valueOf(merchandise.getQuantity()));
        unitLabel.setText(merchandise.getUnit());
    }

}
