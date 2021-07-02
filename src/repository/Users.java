package repository;

import sample.Product;
import sample.User;

import java.sql.ResultSet;
import java.sql.SQLException;

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
//        User user = new User();
//        user.setUsername(result.getString("USERNAME"));

//        public User(ResultSet result) throws SQLException {
//        result.next();
//        username = result.getString("USERNAME");
//        password = result.getString("PASSWORD");
//        type = result.getString("TYPE_NAME");
//        //building = Buildings.GetAssignedBuilding(result);
//    }
        return user;
    }
    public static String getUser(Product product){
        ResultSet result;
        String user = "";
        try {
            result = getDataSQL("SELECT NAME, SURNAME FROM USERS WHERE ID = (SELECT USER_ID FROM PRODUCTS WHERE ID="+product.getId()+")");
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
