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
        private MenuItem shop1Btn;

        @FXML
        private MenuItem shop2Btn;

        @FXML
        private MenuItem shop3Btn;

        private User user;

        private String url = null, title = "";

    @FXML
    void initialize() {
        FXMLLoader loader = new FXMLLoader();
        Parent root;
        Stage stage = new Stage();
        BuildingController controller;
        Consumer<BuildingController> consumer = (c)->{};
        storageBtn.setOnAction(event -> {
            storageBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/sample/storage.fxml", "Склад");
        });

        shop1Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/sample/shop.fxml", "Магазин");
        });

        shop2Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/sample/shop.fxml", "Магазин");
        });

        shop3Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/sample/shop.fxml", "Магазин");
        });

        factoryBtn.setOnAction(event -> {
            factoryBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/sample/factory.fxml", "Завод");
        });

        if(url != null){
            loader.setLocation(getClass().getResource(url));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controller = loader.getController();
            controller.setUser(user);
            consumer.accept(controller);
            root = loader.getRoot();
            stage.setTitle(title);
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        }
    }

    private void SetUrlAndTitle(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }
}