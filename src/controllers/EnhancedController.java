package controllers;

import classes.User;

public interface EnhancedController {
    public void setUser(User user);
    public default void hideBackButton(){}
    public default  void hideUserTab(){}
    public default void hideActionButton(){}
    public default void hideSendChoice(){}
}
