package sample;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String username;
    private String password;
    private String type;
    private Building building;

    public User(ResultSet result) throws SQLException {
        username = result.getString("USERNAME");
        password = result.getString("PASSWORD");
        building = new Building(Users.GetAssignedBuilding(result));
        //type = ...
    }
    public String Type() {
        return type;
    }
    public Building GetBuilding() {
        return building;
    }
}