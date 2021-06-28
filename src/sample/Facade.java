package sample;

public class Facade {
    static Building Authorize(){

    }
    public static User GetUser(String username, String password) {
        return new User(Users.GetUser(username, password));
    }
}
