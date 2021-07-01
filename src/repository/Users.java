package repository;

import sample.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Users extends BaseTable{
    public static User GetUser(String username, String password){
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
}
