package frontend.controllers.warehouse;

import frontend.controllers.UniversalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.concurrent.ExecutionException;

public class WarehouseController {

    @FXML
    void logoutButtonClicked(ActionEvent event) {
        UniversalController.getController().activate("login");
    }

    @FXML
    void newOrderCheckButtonClicked(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/fxml/warehouse/NewOrderCheckScreen.fxml"));
        Stage stage = new Stage();
        stage.setTitle("New order check");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
