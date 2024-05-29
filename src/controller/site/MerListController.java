package controller.site;

import model.Config;
import model.dataholder.Merchandise;
import model.site.MerchandiseAdder;
import controller.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
            MerchandiseAdder merchandiseAdder = new MerchandiseAdder(config.getUsername());
            List<Merchandise> merchandises = merchandiseAdder.getMerchandise();
            System.out.println(merchandises);
            addMerTags(merchandises);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addMerTags(List<Merchandise> merchandises) throws Exception {
        for (Merchandise merchandise : merchandises) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/fxml/site/MerListTag.fxml"));
            HBox merListTag = loader.load();
            MerListTagController merListTagController = loader.getController();

            merListTagController.setData(merchandise);
            mainVBox.getChildren().add(merListTag);
        }
    }

    @FXML
    void addMerButtonClicked(ActionEvent event) throws Exception {
        jump("/view/fxml/site/AddMerScreen.fxml");
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) throws Exception {
        jump("/view/fxml/login/LogInScreen.fxml");
        close(event);
    }

    @FXML
    void sideMerButtonClicked(ActionEvent event) {

    }

    @FXML
    void sideRequestButtonClicked(ActionEvent event) {

    }
    @FXML
    void logoClicked(MouseEvent event) {
        mainVBox.getChildren().clear();
        initialize(null, null);
    }

}
