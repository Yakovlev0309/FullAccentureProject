package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

    public class generalController {

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

    @FXML
    void initialize() {
        FXMLLoader loader = new FXMLLoader();
        storageBtn.setOnAction(event -> {
            storageBtn.getScene().getWindow().hide();

            loader.setLocation(getClass().getResource("/sample/storage.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            storageController storageC = loader.getController();
            storageC.SetUser(user);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Склад");
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        });

        shop1Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();

            loader.setLocation(getClass().getResource("/sample/shop.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            shopController shopC = loader.getController();
            shopC.SetUser(user);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Магазин");
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        });

        shop2Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();

            loader.setLocation(getClass().getResource("/sample/shop.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            shopController shopC = loader.getController();
            shopC.SetUser(user);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Магазин");
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        });

        shop3Btn.setOnAction(event -> {
            shopBtn.getScene().getWindow().hide();

            loader.setLocation(getClass().getResource("/sample/shop.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            shopController shopC = loader.getController();
            shopC.SetUser(user);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Магазин");
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        });

        factoryBtn.setOnAction(event -> {
            factoryBtn.getScene().getWindow().hide();

            loader.setLocation(getClass().getResource("/sample/factory.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            factoryController fC = loader.getController();
            fC.SetUser(user);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Завод");
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        });
    }

    public void SetUser(User user) {
        this.user = user;
    }
}