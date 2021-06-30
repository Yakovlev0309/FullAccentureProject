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

            if (user.getType().equals("user")) {
                FXMLLoader loader = new FXMLLoader();
                switch(user.getBuilding().getType()){
                    case "factory":
                        loader.setLocation(getClass().getResource("/sample/factory.fxml"));
                        factoryController fC = new factoryController();
                        loader.setController(fC);
                        fC.SetBuilding(user.getBuilding());

                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setTitle("Завод");
                        stage.setScene(new Scene(root, 1109, 555));
                        stage.show();
                        break;
                    case "storage":
                        loader.setLocation(getClass().getResource("/sample/storage.fxml"));
                        storageController sC = new storageController();
                        loader.setController(sC);
                        sC.SetBuilding(user.getBuilding());

                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Parent storage_root = loader.getRoot();
                        Stage storage_stage = new Stage();
                        storage_stage.setTitle("Завод");
                        storage_stage.setScene(new Scene(storage_root, 1109, 555));
                        storage_stage.show();
                        break;
                    case "store":
                        loader.setLocation(getClass().getResource("/sample/shop.fxml"));
                        shopController stC = new shopController();
                        loader.setController(stC);
                        stC.SetBuilding(user.getBuilding());

                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Parent store_root = loader.getRoot();
                        Stage store_stage = new Stage();
                        store_stage.setTitle("Завод");
                        store_stage.setScene(new Scene(store_root, 1109, 555));
                        store_stage.show();
                        break;
                }
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
