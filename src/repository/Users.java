package repository;

import org.jetbrains.annotations.Nullable;
import sample.Building;
import sample.Product;
import sample.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Users extends BaseTable{
    public static User getUser(String username, String password){
        ResultSet result;
        User user = new User();
        try {
            result = getDataSQL("SELECT * FROM USERS WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'");
            user = makeUser(result, null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
                users.add(makeUser(result, building));
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
    static User makeUser(ResultSet result, @Nullable Building building){
        User user = new User();
        try {
            if(result.isBeforeFirst()){
                result.next();
            }
            user.setUsername(result.getString("USERNAME"));
            user.setPassword(result.getString("PASSWORD"));
            {
                int typeId = result.getInt("TYPE_ID");
                ResultSet type = getDataSQL("SELECT * FROM USER_TYPES WHERE ID ="+typeId);
                type.next();
                user.setType(type.getString("TYPE_NAME" ));
            }
            user.setBuilding(Objects.requireNonNullElseGet(building, () -> Buildings.GetAssignedBuilding(user)));
            {
                int shiftId = result.getInt("SHIFT_ID");
                ResultSet shift = getDataSQL("SELECT * FROM SHIFTS WHERE ID="+shiftId);
                shift.next();
                try {
                    user.setShift(shift.getString("SHIFT_NAME" ));
                } catch (SQLException throwables) {
                    user.setShift("");
                }
            }
            user.setEfficiency(result.getDouble("EFFICIENCY"));
            user.setName(result.getString("NAME"));
            user.setSurname(result.getString("SURNAME"));
        } catch (SQLException throwables) {
            System.out.println("Пользователь не найден");
            //throwables.printStackTrace();
        }
        return user;
    }
//    public static User getUser(Product product){
//        ResultSet result;
//        User user = new User();
//        result = getDataSQL("")
//    }
}
