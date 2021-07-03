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
            FXMLLoader loader = new FXMLLoader();
            Parent root;
            Stage stage = new Stage();
            String url = null;
            String title = "";
            EnhancedController controller;
            Consumer<EnhancedController> consumer = (c)->{};
            if (user.getType().equals("worker")) {
                consumer = (c)->{c.hideBackButton();c.hideUserTab();};
                switch(user.getBuilding().getType()){
                    case "factory":
                        url = "/sample/factory.fxml";
                        title = "Завод";

                        break;
                    case "storage":
                        url = "/sample/storage.fxml";
                        title = "Склад";
                        break;
                    case "store":
                        url = "/sample/shop.fxml";
                        title = "Магазин";
                }
            } else {
                url = "/sample/general.fxml";
                title = "Главное меню";
            }
            if(url != null){
                loader.setLocation(getClass().getResource(url));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                controller = loader.getController();
                controller.SetUser(user);
                consumer.accept(controller);
                root = loader.getRoot();
                stage.setTitle(title);
                stage.setScene(new Scene(root, 1109, 555));
                stage.show();
            }

        });
    }
}
