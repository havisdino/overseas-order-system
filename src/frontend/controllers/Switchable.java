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

    public Object jump(String fxmlUrl) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlUrl));
        Parent root = loader.load();

//        Parent root = FXMLLoader.load(getClass().getResource(fxmlUrl));
        Stage stage = new Stage();
        stage.setTitle("EasyOrder");
        stage.setScene(new Scene(root));
        stage.show();
        return loader.getController();
    }
}
