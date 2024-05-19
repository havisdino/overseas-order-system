package frontend.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

public class UniversalController {
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene scene;
    private Stage stage;

    private static UniversalController controller = null;

    private UniversalController(Scene scene, Stage stage) throws Exception {
        this.scene = scene;
        this.stage = stage;

        addScreen("login", FXMLLoader.load(getClass().getResource( "/frontend/fxml/login/LogInScreen.fxml" )));
        addScreen("site", FXMLLoader.load(getClass().getResource( "/frontend/fxml/site/MerListScreen.fxml" )));
        addScreen("oopdept", FXMLLoader.load(getClass().getResource( "/frontend/fxml/oopdept/OOPDeptScreen.fxml" )));
        addScreen("salesdept", FXMLLoader.load(getClass().getResource( "/frontend/fxml/salesdept/SalesDepartmentScreen.fxml" )));
        addScreen("warehouse", FXMLLoader.load(getClass().getResource( "/frontend/fxml/warehouse/WarehouseScreen.fxml" )));
    }

    public static UniversalController init(Scene scene, Stage stage) throws Exception {
        if (controller == null) {
            controller = new UniversalController(scene, stage);
        }
        return controller;
    }

    public static UniversalController getController() {
        return controller;
    }

    public Stage getStage() {
        return stage;
    }

    protected void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    public void activate(String name){
        scene.setRoot( screenMap.get(name) );
    }
}
