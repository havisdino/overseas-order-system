package frontend.controllers.login;

import backend.Config;
import backend.database.AccountDatabase;
import backend.database.SQLiteAccountDatabase;
import frontend.controllers.UniversalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

            activateScreen(role);
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }

    void activateScreen(String role) throws Exception {
        String url = "";
        if (role.equals("site")) {
            url = "/frontend/fxml/site/MerListScreen.fxml";
        } else if (role.equals("salesdept")) {
            url = "/frontend/fxml/SalesDepartmentScreen.fxml";
        } else if (role.equals("warehouse")) {
            url = "/frontend/fxml/WarehouseScreen.fxml";
        } else if (role.equals("oopdept")) {
            url = "/frontend/fxml/OOPDeptScreen.fxml";
        }

        Parent root = FXMLLoader.load(getClass().getResource(url));
        Stage stage = new Stage();
        stage.setTitle("Add merchandises");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
