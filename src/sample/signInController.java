package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class signInController {

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
    private TextField logIn_Name;

    @FXML
    private TextField logIn_Surname;

    @FXML
    void initialize() {
        assert logIn != null : "fx:id=\"logIn\" was not injected: check your FXML file 'signIn.fxml'.";
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'signIn.fxml'.";
        assert SignBtn != null : "fx:id=\"SignBtn\" was not injected: check your FXML file 'signIn.fxml'.";
        assert logIn_Name != null : "fx:id=\"logIn_Name\" was not injected: check your FXML file 'signIn.fxml'.";
        assert logIn_Surname != null : "fx:id=\"logIn_Surname\" was not injected: check your FXML file 'signIn.fxml'.";

    }
}
