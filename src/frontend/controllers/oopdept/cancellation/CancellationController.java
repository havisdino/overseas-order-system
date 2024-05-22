package frontend.controllers.oopdept.cancellation;

import backend.CancellationHandler;
import backend.Config;
import backend.Order;
import frontend.controllers.oopdept.orderhandling.OrderTagController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CancellationController implements Initializable {
    private CancellationHandler cancellationHandler;

    @FXML
    private VBox mainVBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cancellationHandler = new CancellationHandler(Config.getInstance().getUsername());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addCancelledOrderTags(List<Order> orders) throws Exception {
        for (Order order : orders) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/frontend/controllers/oopdept/cancellation/CancelledOrderTagController.java"));
            HBox cancelledOrderTag = loader.load();
            CancelledOrderTagController cancelledOrderTagController = loader.getController();

            cancelledOrderTagController.setData(order);
            mainVBox.getChildren().add(cancelledOrderTag);
        }
    }

}