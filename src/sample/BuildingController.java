package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

public abstract class BuildingController {
    @FXML
    Button backBtn;

    @FXML
    Tab userTab;

    User user;

    public abstract void updateTable();
    public void setUser(User user){this.user=user;updateTable();}
    public void hideBackButton(){
        backBtn.setVisible(false);
    }
    public void hideUserTab(){
        userTab.setDisable(true);
    }
}
