package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

public abstract class BuildingController {

    @FXML
    ComboBox<Building> buildingsComboBox;

    @FXML
    Button backBtn;

    @FXML
    Button actionBtn;

    @FXML
    Tab userTab;

    @FXML
    Label userLabel;

    User user;

    public abstract void updateTable();
    public void setUser(User user){
        this.user = user;
        userLabel.textProperty().set(user.toString());
        updateTable();
    }
    public void hideBackButton(){
        backBtn.setVisible(false);
    }
    public void hideUserTab(){
        userTab.setDisable(true);
    }
    public void hideActionButton(){actionBtn.setVisible(false);}
}
