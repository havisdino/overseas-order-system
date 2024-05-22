package frontend.controllers.oopdept.orderhandling;

import backend.SiteInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SiteTagController {
    private SiteInfo siteInfo;
    SiteInfoController siteInfoController;

    @FXML
    private Button addButton;

    @FXML
    private Label nameLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private TextField requestQuantityField;

    @FXML
    private Label siteCodeLabel;

    @FXML
    void addButtonClicked(ActionEvent event) {
        addButton.setDisable(true);
        addButton.setStyle("-fx-text-fill: -color-base-4");
        siteInfoController.setSelectedQuantity(Integer.parseInt(requestQuantityField.getText()));
    }

    public void setData(SiteInfo siteInfo) {
        this.siteInfo = siteInfo;
        siteCodeLabel.setText(siteInfo.getCode());
        nameLabel.setText(siteInfo.getName());
        quantityLabel.setText(String.valueOf(siteInfo.getQuantity()));
    }

    public void setParentController(SiteInfoController c) {
        siteInfoController = c;
    }

    public Button getAddButton() {
        return addButton;
    }
}
