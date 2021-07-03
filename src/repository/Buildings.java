package repository;

import sample.Building;
import sample.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Buildings extends BaseTable{

    public static Building GetAssignedBuilding(User user){
        ResultSet result;
        Building building = new Building();

        try {
            result = getDataSQL("SELECT BUILDINGS.ID, BUILDINGS.NAME, BUILDING_TYPES.TYPE_NAME FROM BUILDINGS INNER JOIN BUILDING_TYPES ON BUILDINGS.TYPE_ID=BUILDING_TYPES.ID WHERE BUILDINGS.ID = (SELECT BUILDING_ID FROM USERS WHERE USERNAME = '"+user.getUsername()+"' AND PASSWORD = '"+user.getPassword()+"')");
            result.next();
            building.setId(result.getInt("ID"));
            building.setType(result.getString("TYPE_NAME"));
            building.setName(result.getString("NAME"));
            building.setProducts(Products.getProducts(building));
            building.setUsers(Users.getUsers(building));
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
        return building;
    }
//    public static ArrayList<Building> getAllBuildings(User user){
//
//    }
}
