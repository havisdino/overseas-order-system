package controller.oopdept.orderhandling;

import model.*;
import controller.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OrderHandlingController extends Switchable implements Initializable {

    private Order order;

    @FXML
    private VBox mainVBox;

    @FXML
    private Label dateLabel;

    @FXML
    private Label orderIDLabel;

    @FXML
    private Label salesDepartmentIDLabel;

    @FXML
    private Label descLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            String id = Config.getInstance().getUsername();
            OOPDepartment oopDept = new OOPDepartment(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addMerTags(List<Merchandise> mers) throws Exception {
        for (Merchandise m : mers) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/fxml/oopdept/orderhandling/MerchandiseTag.fxml"));
            HBox merTag = loader.load();
            MerchandiseTagController merTagController = loader.getController();

            merTagController.setData(m, order);
            mainVBox.getChildren().add(merTag);
        }
    }

    @FXML
    void stashButtonClicked(ActionEvent event) throws Exception {
        CancellationHandler cancellationHandler = new CancellationHandler(Config.getInstance().getUsername());
        cancellationHandler.stashOrder(order.getId());
        close(event);
    }

    @FXML
    void placeButtonClicked(ActionEvent event) {
        // place order here
        close(event);
    }

    public void setData(Order order) throws Exception {
        this.order = order;
        orderIDLabel.setText(order.getId());
        salesDepartmentIDLabel.setText(order.getSalesDeptID());
        dateLabel.setText(order.getDateCreatedInString());
        descLabel.setText(order.getDescription());
        List<Merchandise> mers = order.getMerchandiseList();
        addMerTags(mers);
    }

}
