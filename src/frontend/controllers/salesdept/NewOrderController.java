package frontend.controllers.salesdept;

import backend.*;
import backend.database.RawMerchandiseDatabase;
import backend.database.SQLiteRawMerchandiseDatabase;
import frontend.controllers.Switchable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class NewOrderController extends Switchable implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField descField;

    @FXML
    private VBox mainVBox;

    private List<Merchandise> cart = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            RawMerchandiseDatabase db = new SQLiteRawMerchandiseDatabase();
            List<RawMerchandise> merchandises = db.getMerchandisesExceptSite(Config.getInstance().getUsername());
            addMerTags(merchandises);

            SalesDepartment salesDept = new SalesDepartment(Config.getInstance().getUsername());
            List<String> oopDeptIDs = salesDept.getOOPDeptIDs();
            ObservableList<String> items = FXCollections.observableList(oopDeptIDs);
            choiceBox.setItems(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void discardButtonClicked(ActionEvent event) {
        close(event);
    }

    @FXML
    void doneButtonClicked(ActionEvent event) throws Exception {
        String desc = descField.getText();
        String oopDeptID = choiceBox.getValue();
        Order order = new Order(cart, new Date(), desc, Config.getInstance().getUsername(), oopDeptID);
        SalesDepartment sd = new SalesDepartment(Config.getInstance().getUsername());
        sd.createOrder(order);
        close(event);
    }

    void addMerTags(List<RawMerchandise> merchandises) throws Exception {
        for (RawMerchandise m : merchandises) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/frontend/fxml/salesdept/MerTag.fxml"));
            HBox merTag = loader.load();
            MerTagController merTagController = loader.getController();

            merTagController.setCart(cart);
            merTagController.setData(m);
            mainVBox.getChildren().add(merTag);
        }
    }

}
