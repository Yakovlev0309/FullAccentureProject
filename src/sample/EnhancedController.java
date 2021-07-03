package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

public interface EnhancedController {
//    @FXML
//    Button backBtn = null;
//    @FXML
//    Tab userTab = new Tab();

    public void SetUser(User user);
    public void UpdateTable();
    public void  hideBackButton();
    public void  hideUserTab();
//    public default void hideBackButton(){
//        backBtn.setVisible(false);
//    }
//    public default void hideUserTab(){
//        userTab.setDisable(true);
//    }
}
