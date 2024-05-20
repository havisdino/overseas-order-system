package frontend.controllers.site;

import backend.Config;
import backend.Merchandise;
import backend.Site;
import frontend.controllers.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MerListController extends Switchable implements Initializable {

    @FXML
    private VBox mainVBox;

    @FXML
    private Label currentScreenLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Config config = Config.getInstance();
        try{
            Site site = new Site(config.getUsername());
            List<Merchandise> merchandises = site.getMerchandise();
            addMerTags(merchandises);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addMerTags(List<Merchandise> merchandises) throws Exception {
        for (Merchandise merchandise : merchandises) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/frontend/fxml/site/MerListTag.fxml"));
            HBox merListTag = loader.load();
            MerListTagController merListTagController = loader.getController();

            merListTagController.setData(merchandise);
            mainVBox.getChildren().add(merListTag);
        }
    }

    @FXML
    void addMerButtonClicked(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/fxml/site/AddMerScreen.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Add merchandises");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/fxml/login/LogInScreen.fxml"));
        Stage stage = new Stage();
        stage.setTitle("EasyOrder");
        stage.setScene(new Scene(root));
        stage.show();
        close(event);
    }

    @FXML
    void sideMerButtonClicked(ActionEvent event) {

    }

    @FXML
    void sideRequestButtonClicked(ActionEvent event) {

    }

}
