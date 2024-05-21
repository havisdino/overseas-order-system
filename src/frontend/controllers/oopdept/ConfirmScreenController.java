package frontend.controllers.oopdept;

import frontend.controllers.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ConfirmScreenController extends Switchable {

    @FXML
    private TextField noteField;

    @FXML
    void backButtonClicked(ActionEvent event) {
        close(event);
    }

    @FXML
    void confirmButtonClicked(ActionEvent event) {
        String note = noteField.getText();

    }

}
