package frontend.controllers.oopdept;

import backend.Config;
import backend.OOPDepartment;
import backend.Order;
import frontend.controllers.Switchable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomePageController extends Switchable implements Initializable {

    @FXML
    private VBox mainVBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            OOPDepartment oopDept = new OOPDepartment(Config.getInstance().getUsername());
            List<Order> orders = oopDept.getOrderList();
            addOrderTag(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addOrderTag(List<Order> orders) throws Exception {
        for (Order order : orders) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/frontend/fxml/oopdept/OrderTag.fxml"));
            HBox orderTag = loader.load();
            OrderTagController orderTagController = loader.getController();

            orderTagController.setData(order);
            mainVBox.getChildren().add(orderTag);
        }
    }
}
