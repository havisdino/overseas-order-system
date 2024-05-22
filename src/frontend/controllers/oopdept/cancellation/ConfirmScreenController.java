package frontend.controllers.oopdept.cancellation;

import frontend.controllers.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ConfirmScreenController extends Switchable {
    private CancelledOrderTagController cancelledOrderTagController;

    @FXML
    private TextField noteField;

    @FXML
    void backButtonClicked(ActionEvent event) {
        close(event);
    }

    @FXML
    void confirmButtonClicked(ActionEvent event) throws Exception {
        String note = noteField.getText();
        cancelledOrderTagController.confirmCancel(note);
        close(event);
    }

    public void setParentController(CancelledOrderTagController c) {
        cancelledOrderTagController = c;
    }

}
