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
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Text errorMessage;

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
        errorMessage.setVisible(false);

        logIn.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){SignBtn.fire();}
        });

        pass.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){SignBtn.fire();}
        });

        SignBtn.setOnAction(event -> {


            user = Facade.GetUser(logIn.getText(), pass.getText());
            FXMLLoader loader = new FXMLLoader();
            Parent root;
            Stage stage = new Stage();
            String url = null;
            String title = "";
            EnhancedController controller;
            Consumer<EnhancedController> consumer = (c)->{};

            if(user.getType()==null){
                logIn.setText("");
                pass.setText("");
                errorMessage.setVisible(true);
                return;
            }
            SignBtn.getScene().getWindow().hide();

            switch (user.getType()) {
                case "director":
                    url = "/sample/general.fxml";
                    title = "Главное меню";
                    break;
                default:
                    title = user.getBuilding().getName();
                    switch(user.getBuilding().getType()){
                        case "factory":
                            url = "/sample/factory.fxml";
                            break;
                        case "storage":
                            url = "/sample/storage.fxml";
                            break;
                        case "store":
                            url = "/sample/shop.fxml";
                    }
                    switch (user.getType()) {
                        case "worker":
                            consumer = (c) -> {
                                c.hideBackButton();
                                c.hideUserTab();
                            };
                            break;
                        case "department_director":
                            consumer = (c) -> {
                                c.hideBackButton();
                            };
                            break;
                    }
                    break;
            }
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
        });
    }
}
