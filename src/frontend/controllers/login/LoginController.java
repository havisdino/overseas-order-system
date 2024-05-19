package frontend.controllers.login;

import backend.database.AccountDatabase;
import frontend.controllers.UniversalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    AccountDatabase accDB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize accDB here
    }

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void loginButtonClicked(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        String role = accDB.findUserRole(username, password);

        if (role == null) {
            System.out.println("Wrong info");
            usernameField.clear();
            passwordField.clear();
        } else {
            UniversalController.getController().activate(role);
        }
    }
}
