package frontend.controllers.warehouse;

import frontend.controllers.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WarehouseController extends Switchable {

    @FXML
    void logoutButtonClicked(ActionEvent event) throws Exception {
        jump("/frontend/fxml/login/LogInScreen.fxml");
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
