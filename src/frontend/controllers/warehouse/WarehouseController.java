package frontend.controllers.warehouse;

import backend.Config;
import backend.OrderCheck;
import backend.RawMerchandise;
import backend.Warehouse;
import frontend.controllers.Switchable;
import frontend.controllers.salesdept.MerTagController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WarehouseController extends Switchable implements Initializable {

    @FXML
    private VBox mainVBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Warehouse warehouse = new Warehouse(Config.getInstance().getUsername());
            List<OrderCheck> orderChecks = warehouse.getOrderCheckList();
            addOrderCheckTags(orderChecks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) throws Exception {
        jump("/frontend/fxml/login/LogInScreen.fxml");
        close(event);
    }

    @FXML
    void newOrderCheckButtonClicked(ActionEvent event) throws Exception {
        jump("/frontend/fxml/warehouse/NewOrderCheckScreen.fxml");
    }

    private void addOrderCheckTags(List<OrderCheck> orderChecks) throws Exception {
        for (OrderCheck orderCheck : orderChecks) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/frontend/fxml/warehouse/OrderTag.fxml"));
            HBox orderTag = loader.load();
            OrderTagController orderTagController = loader.getController();
            orderTagController.setData(orderCheck);
            mainVBox.getChildren().add(orderTag);
        }
    }
}
