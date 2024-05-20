package frontend.controllers.site;

import backend.Config;
import backend.Merchandise;
import backend.RawMerchandise;
import backend.Site;
import backend.database.RawMerchandiseDatabase;
import backend.database.SQLiteRawMerchandiseDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddMerController implements Initializable {
    private List<Merchandise> cart = new ArrayList<>();

    @FXML
    private VBox mainVBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            RawMerchandiseDatabase db = new SQLiteRawMerchandiseDatabase();
            List<RawMerchandise> merchandises = db.getMerchandises();
            addRawMerTag(merchandises);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void addRawMerTag(List<RawMerchandise> merchandises) throws Exception {
        for (RawMerchandise merchandise : merchandises) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/frontend/fxml/site/AddMerTag.fxml"));
            HBox addMerTag = loader.load();
            AddMerTagController addMerTagController = loader.getController();
            addMerTagController.setCart(cart);
            addMerTagController.setData(merchandise);
            mainVBox.getChildren().add(addMerTag);
        }
    }

    @FXML
    void discardButtonClicked(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void doneButtonClicked(ActionEvent event) throws Exception {
        Site site = new Site(Config.getInstance().getUsername());;
        for (Merchandise m : cart) {
            site.addMerchandise(m.getQuantity(), m.getCode());
        }
    }

}
