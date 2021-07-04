package sample;

import repository.Buildings;
import repository.Users;

public class Facade {
    /*
    static Building Authorize(){

    }*/

    public static User GetUser(String username, String password) {
        return Users.getUser(username, password);
    }
    public static  Building getBuildingByName(String name){
        return Buildings.getBuilding(name);
    }
}
