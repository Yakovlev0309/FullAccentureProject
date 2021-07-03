package repository;

import sample.Building;
import sample.Product;
import sample.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users extends BaseTable{
    public static User getUser(String username, String password){
        ResultSet result;
        User user;
        try {
            result = getDataSQL("SELECT * FROM USERS INNER JOIN SHIFTS ON USERS.SHIFT_ID=SHIFTS.ID INNER JOIN USER_TYPES ON USERS.TYPE_ID=USER_TYPES.ID WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'");
            result.next();
            user = new User();
            user.setUsername(result.getString("USERNAME"));
            user.setPassword(result.getString("PASSWORD"));
            user.setType(result.getString("TYPE_NAME"));
            user.setBuilding(Buildings.GetAssignedBuilding(user));
            user.setShift(result.getString("SHIFT_NAME"));
            user.setEfficiency(result.getDouble("EFFICIENCY"));
            user.setName(result.getString("NAME"));
            user.setSurname(result.getString("SURNAME"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new User();
        }
        return user;
    }
    public static ArrayList<User> getUsers(Building building){
        ArrayList<User> users = new ArrayList<>();
        ResultSet result;
        User user;
        try {
            result = getDataSQL("SELECT * FROM USERS WHERE BUILDING_ID = (SELECT ID FROM BUILDINGS WHERE NAME = '"+building.getName()+"')");
            while (result.next()){
                user = new User();
                user.setUsername(result.getString("USERNAME"));
                user.setPassword(result.getString("PASSWORD"));
                {
                    //Установка типа
                    ResultSet type = getDataSQL("SELECT * FROM USER_TYPES WHERE ID ="+result.getInt("TYPE_ID"));
                    type.next();
                    user.setType(type.getString("TYPE_NAME"));
                }
                user.setBuilding(building);
                {
                    //Установка смены
                    ResultSet shift = getDataSQL("SELECT * FROM SHIFTS WHERE ID ="+result.getInt("SHIFT_ID"));
                    shift.next();
                    user.setShift(shift.getString("SHIFT_NAME"));
                }
                user.setEfficiency(result.getDouble("EFFICIENCY"));
                user.setName(result.getString("NAME"));
                user.setSurname(result.getString("SURNAME"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
    public static String getUser(Product product){
        ResultSet result;
        String user = "";
        try {
            result = getDataSQL("SELECT NAME, SURNAME FROM USERS WHERE ID = (SELECT USER_ID FROM PRODUCTS WHERE ID="+product.getId()+")");
            result.next();
            user = result.getString("NAME")+" "+result.getString("SURNAME");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
//    public static User getUser(Product product){
//        ResultSet result;
//        User user = new User();
//        result = getDataSQL("")
//    }
}
