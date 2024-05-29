package controller.warehouse;

import model.*;
import model.database.RawMerchandiseDatabase;
import model.database.SQLiteRawMerchandiseDatabase;
import controller.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.dataholder.Merchandise;
import model.dataholder.OrderCheck;
import model.dataholder.RawMerchandise;
import model.warehouse.OrderChecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class NewOrderCheckController extends Switchable implements Initializable {
    private List<Merchandise> cart;

    @FXML
    private VBox mainVBox;

    @FXML
    private TextField orderIDField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cart = new ArrayList<>();
            RawMerchandiseDatabase db = new SQLiteRawMerchandiseDatabase();
            List<RawMerchandise> merchandises = db.getMerchandisesExceptSite(Config.getInstance().getUsername());
            addMerTags(merchandises);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void discardButtonClicked(ActionEvent event) throws Exception {
        close(event);
    }

    @FXML
    void doneButtonClicked(ActionEvent event) throws Exception {
        String orderID = orderIDField.getText();
        OrderCheck orderCheck = new OrderCheck(orderID, cart, new Date(), null);
        orderCheck.setWarehouseID(Config.getInstance().getUsername());

        OrderChecker orderChecker = new OrderChecker(Config.getInstance().getUsername());
        orderChecker.createOrderCheck(orderCheck);
        close(event);
    }

    void addMerTags(List<RawMerchandise> merchandises) throws Exception {
        for (RawMerchandise m : merchandises) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/fxml/warehouse/MerTag.fxml"));
            HBox merTag = loader.load();
            MerTagController merTagController = loader.getController();

            merTagController.setCart(cart);
            merTagController.setData(m);
            mainVBox.getChildren().add(merTag);
        }
    }

}
