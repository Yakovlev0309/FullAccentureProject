package controllers;

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
import classes.Facade;
import classes.User;

public class generalController implements EnhancedController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private Button signUpBtn;

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
            building_name = "Склад №1";
            SetUrlAndTitle("/controllers/storage.fxml", building_name);
            openNewController();
        });

        shop1Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();
            building_name = "Магазин №1";
            SetUrlAndTitle("/controllers/shop.fxml", building_name);
            openNewController();

        });

        shop2Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();
            building_name = "Магазин №2";
            SetUrlAndTitle("/controllers/shop.fxml", building_name);
            openNewController();

        });

        shop3Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();
            building_name = "Магазин №3";
            SetUrlAndTitle("/controllers/shop.fxml", building_name);
            openNewController();
        });

        factoryBtn.setOnAction(event -> {
            factoryBtn.getScene().getWindow().hide();
            building_name = "Завод №1";
            SetUrlAndTitle("/controllers/factory.fxml", building_name);
            openNewController();
        });

        exitBtn.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            Parent root;
            Stage stage = new Stage();
            loader.setLocation(getClass().getResource("/controllers/sample.fxml"));
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

        signUpBtn.setOnAction(event -> {
            signUpBtn.getScene().getWindow().hide();
            SetUrlAndTitle("/controllers/signIn.fxml", "Регистрация пользователя");
            FXMLLoader loader = new FXMLLoader();
            Parent root;
            Stage stage = new Stage();
            signInController controller;
            if(url != null){
                loader.setLocation(getClass().getResource(url));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                controller = loader.getController();
                controller.setUser(user);
                root = loader.getRoot();
                stage.setTitle(title);
                stage.setScene(new Scene(root, 1109, 555));
                stage.show();
            }
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
        EnhancedController controller;
        Consumer<EnhancedController> consumer = (c) -> {
            c.hideActionButton();
            c.hideSendChoice();
        };
        if(url != null){
            loader.setLocation(getClass().getResource(url));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controller = loader.getController();
            consumer.accept(controller);
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