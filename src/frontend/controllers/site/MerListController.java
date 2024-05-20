package frontend.controllers.site;

import backend.Config;
import backend.Merchandise;
import backend.Site;
import frontend.controllers.UniversalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MerListController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Config config = Config.getInstance();
        try{
            Site site = new Site(config.getUsername());
            List<Merchandise> mers = site.getMerchandise();
            System.out.println(mers.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label currentScreenLabel;

    @FXML
    void addMerButtonClicked(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/fxml/site/AddMerScreen.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Add merchandises");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) {
        UniversalController.getController().activate("login");
    }

    @FXML
    void sideMerButtonClicked(ActionEvent event) {

    }

    @FXML
    void sideRequestButtonClicked(ActionEvent event) {

    }

}
