package frontend.controllers.oopdept;

import backend.Config;
import backend.Merchandise;
import backend.OOPDepartment;
import backend.Order;
import frontend.controllers.Switchable;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            OOPDepartment oopDept = new OOPDepartment(Config.getInstance().getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addMerTags(List<Merchandise> mers) throws Exception {
        for (Merchandise m : mers) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/frontend/fxml/oopdept/MerchandiseTag.fxml"));
            HBox merTag = loader.load();
            MerchandiseTagController merTagController = loader.getController();

            merTagController.setData(m);
            mainVBox.getChildren().add(merTag);
        }
    }

    @FXML
    void cancelButtonClicked(ActionEvent event) {
        // stash order
        close(event);
    }

    @FXML
    void placeButtonClicked(ActionEvent event) {

        close(event);
    }

    public void setData(Order order) throws Exception {
        this.order = order;
        orderIDLabel.setText(order.getId());
        salesDepartmentIDLabel.setText(order.getSalesDeptID());
        dateLabel.setText(order.getDateCreatedInString());
        List<Merchandise> mers = order.getMerchandiseList();
        addMerTags(mers);
    }

}
