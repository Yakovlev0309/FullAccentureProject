package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

public interface EnhancedController {
    public void setUser(User user);
    public default void hideBackButton(){}
    public default  void hideUserTab(){}
    public default void hideActionButton(){}
}
