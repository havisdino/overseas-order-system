package frontend.controllers.oopdept.cancellation;

import backend.CancellationHandler;
import backend.Config;
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
    void confirmButtonClicked(ActionEvent event) throws Exception {
        CancellationHandler cancellationHandler = new CancellationHandler(Config.getInstance().getUsername());
        String note = noteField.getText();
        // Confirm deletion

    }

}
