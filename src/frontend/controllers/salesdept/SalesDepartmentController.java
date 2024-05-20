package frontend.controllers.salesdept;

import backend.Config;
import backend.Order;
import backend.SalesDepartment;
import frontend.controllers.Switchable;
import frontend.controllers.UniversalController;
import frontend.controllers.site.MerListTagController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SalesDepartmentController extends Switchable implements Initializable {

    @FXML
    private VBox mainVBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            SalesDepartment salesDept = new SalesDepartment(Config.getInstance().getUsername());
            List<Order> orders = salesDept.getOrderList();
            addOrderTags(orders);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addOrderTags(List<Order> orders) throws Exception {
        for (Order order : orders) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/frontend/fxml/salesdept/OrderTag.fxml.fxml"));
            HBox orderTag = loader.load();
            OrderTagController orderTagController = loader.getController();

            orderTagController.setData(order);
            mainVBox.getChildren().add(orderTag);
        }
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) throws Exception {
        jump("/frontend/fxml/login/LogInScreen.fxml");
        close(event);
    }

    @FXML
    void newOrderButtonClicked(ActionEvent event) {

    }
}
