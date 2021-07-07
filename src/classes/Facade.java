package classes;

import repository.Buildings;
import repository.Products;
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
    public static void makeNewProduct(Building building, User user){
        Product product = Products.createNewProduct(building, user);
        building.getProducts().add(product);
    }
}
