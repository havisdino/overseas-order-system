package controller.salesdept;

import model.Config;
import model.dataholder.Order;
import model.salesdept.OrderPlacer;
import controller.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
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
            OrderPlacer salesDept = new OrderPlacer(Config.getInstance().getUsername());
            List<Order> orders = salesDept.getOrderList();
            addOrderTags(orders);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addOrderTags(List<Order> orders) throws Exception {
        for (Order order : orders) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/fxml/salesdept/OrderTag.fxml"));
            HBox orderTag = loader.load();
            OrderTagController orderTagController = loader.getController();

            orderTagController.setData(order);
            mainVBox.getChildren().add(orderTag);
        }
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) throws Exception {
        jump("/view/fxml/login/LogInScreen.fxml");
        close(event);
    }

    @FXML
    void newOrderButtonClicked(ActionEvent event) throws Exception {
        jump("/view/fxml/salesdept/NewOrderScreen.fxml");
    }

    @FXML
    void logoClicked(MouseEvent event) {
        mainVBox.getChildren().clear();
        initialize(null, null);
    }
}
