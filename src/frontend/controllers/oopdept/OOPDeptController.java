package frontend.controllers.oopdept;

import frontend.controllers.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class OOPDeptController extends Switchable implements Initializable {

    @FXML
    private Button cancellationButton;

    @FXML
    private Button homeButton;

    @FXML
    private HBox mainHBox;

    private VBox mainPage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getHome();
    }

    private void alterPage(String fxmlUrl) {
        if (mainPage != null) {
            mainHBox.getChildren().remove(mainPage);
        }
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlUrl));
            mainPage = loader.load();
            HBox.setHgrow(mainPage, Priority.ALWAYS);
            mainHBox.getChildren().add(mainPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getHome() {
        alterPage("/frontend/fxml/oopdept/orderhandling/HomePage.fxml");
        disableButton(homeButton);
        enableButton(cancellationButton);
    }

    private void goToCancellationPage() {
        alterPage("/frontend/fxml/oopdept/cancellation/CancellationPage.fxml");
        disableButton(cancellationButton);
        enableButton(homeButton);
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) throws Exception {
        jump("/frontend/fxml/login/LogInScreen.fxml");
        close(event);
    }


    @FXML
    void cancelledButtonClicked(ActionEvent event) {
        goToCancellationPage();
    }

    @FXML
    void homeButtonClicked(ActionEvent event) {
        mainHBox.getChildren().remove(mainPage);
        getHome();
    }

    private void disableButton(Button button) {
        button.setStyle("-fx-text-fill: -color-accent-5; -fx-background-color: 0");
    }

    private void enableButton(Button button) {
        button.setStyle("-fx-text-fill: black; -fx-background-color: 0");
    }

    @FXML
    void logoClicked(MouseEvent event) {
        getHome();
    }
}