package sample;

import repository.Users;

public class Facade {
    /*
    static Building Authorize(){

    }*/

    public static User GetUser(String username, String password) {
        return Users.getUser(username, password);
    }
}
