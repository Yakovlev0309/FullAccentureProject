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
            result = getDataSQL("SELECT * FROM BUILDINGS WHERE ID = (SELECT BUILDING_ID FROM USERS WHERE USERNAME='"+user.getUsername()+"' AND PASSWORD='"+user.getPassword()+"')");
            building = makeBuilding(result);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return building;
    }
    public static Building getBuilding(String name){
        Building building = new Building();
        ResultSet result;
        try {
            result = getDataSQL("SELECT * FROM BUILDINGS WHERE NAME='"+name+"'");
            building = makeBuilding(result);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return building;
    }
    static Building makeBuilding(ResultSet result){
        Building building = new Building();
        try {
            if(result.isBeforeFirst()){
                result.next();
            }
            building.setId(result.getInt("ID"));
            {
                int typeId = result.getInt("TYPE_ID");
                ResultSet type = getDataSQL("SELECT * FROM BUILDING_TYPES WHERE ID="+typeId);
                type.next();
                building.setType(type.getString("TYPE_NAME"));
            }
            building.setName(result.getString("NAME"));
            building.setProducts(Products.getProducts(building));
            building.setUsers(Users.getUsers(building));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return building;
    }
//    public static ArrayList<Building> getAllBuildings(User user){
//
//    }
}
