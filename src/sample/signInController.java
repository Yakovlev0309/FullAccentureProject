package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import repository.Buildings;

public class signInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private ComboBox buildingField;

    @FXML
    private ComboBox shiftField;

    @FXML
    private Button signUpBtn;

    @FXML
    private Button backBtn;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private Text errorMessage;

    private User user;

    private ObservableList<Building> buildings = FXCollections.observableArrayList();

    private ObservableList<Integer> shifts = FXCollections.observableArrayList(1, 2);

    @FXML
    void initialize() {
        errorMessage.setVisible(false);

        buildings.setAll(Buildings.getBuildings(null));
        buildingField.setItems(buildings);

        shiftField.setItems(shifts);

        signUpBtn.setOnAction(event -> {
            signUpBtn.getScene().getWindow().hide();

            if(nameField.getText() == null || surnameField.getText() == null || loginField.getText() == null || passwordField.getText() == null || buildingField.getValue() == null || shiftField.getValue() == null) {
                errorMessage.setVisible(true);
                return;
            }

            //Добавление в базу
//            user.AddUser(nameField.getText(), surnameField.getText(), logInField.getText(), passwordField.getText(), buildingField.getValue(), shiftField.getValue());

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/general.fxml"));
            generalController controller;
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controller = loader.getController();
            controller.setUser(user);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Главное меню");
            stage.setScene(new Scene(root));
            stage.show();
        });

        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/general.fxml"));
            generalController controller;
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controller = loader.getController();
            controller.setUser(user);
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Главное меню");
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    public void setUser(User user) {
        this.user = user;
    }
}
