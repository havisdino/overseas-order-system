package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Switchable {
    public void close(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    public void jump(String fxmlUrl) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlUrl));
        Stage stage = new Stage();
        stage.setTitle("EasyOrder");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
