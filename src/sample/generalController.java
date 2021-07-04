package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

    public class generalController implements EnhancedController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private MenuButton shopBtn;

        @FXML
        private Button storageBtn;

        @FXML
        private Button factoryBtn;

        @FXML
        private Button exitBtn;

        @FXML
        private MenuItem shop1Btn;

        @FXML
        private MenuItem shop2Btn;

        @FXML
        private MenuItem shop3Btn;

        private User user;

        private String url = null, title = "";

        private String building_name = "";

    @FXML
    void initialize() {
        storageBtn.setOnAction(event -> {
            storageBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/sample/storage.fxml", "Склад");
            building_name = "storage1";
            openNewController();
        });

        shop1Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/sample/shop.fxml", "Магазин");
            building_name = "store1";
            openNewController();

        });

        shop2Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/sample/shop.fxml", "Магазин");
            building_name = "store2";
            openNewController();

        });

        shop3Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/sample/shop.fxml", "Магазин");
            building_name = "store3";
            openNewController();
        });

        factoryBtn.setOnAction(event -> {
            factoryBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/sample/factory.fxml", "Завод");
            building_name = "factory1";
            openNewController();
        });

        exitBtn.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            Parent root;
            Stage stage = new Stage();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            exitBtn.getScene().getWindow().hide();
            root = loader.getRoot();
            stage.setTitle("Авторизация");
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        });
    }

    private void SetUrlAndTitle(String url, String title) {
        this.url = url;
        this.title = title;
    }
    void openNewController(){
        FXMLLoader loader = new FXMLLoader();
        Parent root;
        Stage stage = new Stage();
        BuildingController controller;
        if(url != null){
            loader.setLocation(getClass().getResource(url));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controller = loader.getController();
            user.setBuilding(Facade.getBuildingByName(building_name));
            controller.setUser(user);
            root = loader.getRoot();
            stage.setTitle(title);
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }
}