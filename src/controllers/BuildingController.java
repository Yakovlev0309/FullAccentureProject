package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import classes.Building;
import classes.User;

public abstract class BuildingController {

    @FXML
    ComboBox<Building> buildingsComboBox;

    @FXML
    Button backBtn;

    @FXML
    Button actionBtn;

    @FXML
    Button sendBtn;

    @FXML
    Tab userTab;

    @FXML
    Label userLabel;

    User user;

    public abstract void updateTable();
    public void setUser(User user){
        this.user = user;
        userLabel.textProperty().set("Вход выполнен:\n"+user.toString());
        updateTable();
    }
    public void hideBackButton(){
        backBtn.setVisible(false);
    }
    public void hideUserTab(){
        userTab.setDisable(true);
    }
    public void hideActionButton(){actionBtn.setVisible(false);}
    public void hideSendChoice(){
        sendBtn.setVisible(false);
        buildingsComboBox.setVisible(false);
    }
}
