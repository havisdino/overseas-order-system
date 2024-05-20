package frontend.controllers.login;

import backend.Config;
import backend.database.AccountDatabase;
import backend.database.SQLiteAccountDatabase;
import frontend.controllers.UniversalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void loginButtonClicked(ActionEvent event) throws Exception {
        Config config = Config.getInstance();
        AccountDatabase accDB = new SQLiteAccountDatabase();

        String username = usernameField.getText();
        String password = passwordField.getText();

        String role = accDB.findUserRole(username, password);

        if (role == null) {
            System.out.println("Wrong info");
            usernameField.clear();
            passwordField.clear();
        } else {
            config.setUsername(username);
            config.setPassword(password);
            config.setRole(role);
            UniversalController.getController().activate(role);
        }
    }
}
