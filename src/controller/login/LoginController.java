package controller.login;

import model.Config;
import model.database.AccountDatabase;
import model.database.SQLiteAccountDatabase;
import controller.Switchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController extends Switchable {

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
            close(event);
        }
    }

    void activateScreen(String role) throws Exception {
        String url = "";
        if (role.equals("site")) {
            url = "/view/fxml/site/MerListScreen.fxml";
        } else if (role.equals("salesdept")) {
            url = "/view/fxml/salesdept/SalesDepartmentScreen.fxml";
        } else if (role.equals("warehouse")) {
            url = "/view/fxml/warehouse/WarehouseScreen.fxml";
        } else if (role.equals("oopdept")) {
            url = "/view/fxml/oopdept/OOPDeptScreen.fxml";
        }
        System.out.println(url);
        jump(url);
    }
}