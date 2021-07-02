package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField logIn;

    @FXML
    private PasswordField pass;

    @FXML
    private Button SignBtn;

    @FXML
    private Hyperlink hypertext;

    private User user;

    @FXML
    void initialize() {
        //Регистрация
            hypertext.setOnAction(event -> {
                 hypertext.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/signIn.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            });
        //Вызов general
        SignBtn.setOnAction(event -> {
            SignBtn.getScene().getWindow().hide();

            user = Facade.GetUser(logIn.getText(), pass.getText());

            if (user.getType().equals("worker")) {
                FXMLLoader loader = new FXMLLoader();
                Parent root;
                Stage stage = new Stage();
                switch(user.getBuilding().getType()){
                    case "factory":
                        loader.setLocation(getClass().getResource("/sample/factory.fxml"));
                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        factoryController fC = loader.getController();
                        fC.SetUser(user);
                        root = loader.getRoot();
                        stage.setTitle("Завод");
                        stage.setScene(new Scene(root, 1109, 555));
                        stage.show();
                        break;
                    case "storage":
                        loader.setLocation(getClass().getResource("/sample/storage.fxml"));
                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        storageController storageC = loader.getController();
                        storageC.SetBuilding(user.getBuilding());
                        root = loader.getRoot();
                        stage.setTitle("Склад");
                        stage.setScene(new Scene(root, 1109, 555));
                        stage.show();
                        break;
                    case "store":
                        loader.setLocation(getClass().getResource("/sample/shop.fxml"));
                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        shopController shopC = loader.getController();
                        shopC.SetBuilding(user.getBuilding());
                        root = loader.getRoot();
                        stage.setTitle("Магазин");
                        stage.setScene(new Scene(root, 1109, 555));
                        stage.show();
                }
                //Скрыть кнопку назад
            } else {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/general.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Главное меню");
                stage.setScene(new Scene(root, 1109, 555));
                stage.show();
            }
        });
    }
}
