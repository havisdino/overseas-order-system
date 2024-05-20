package frontend.controllers.salesdept;

import backend.Site;
import frontend.controllers.UniversalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SalesDepartmentController implements Initializable {

    @FXML
    private VBox mainVBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void logoutButtonClicked(ActionEvent event) {
        UniversalController.getController().activate("login");
    }

    @FXML
    void newOrderButtonClicked(ActionEvent event) {

    }
}
