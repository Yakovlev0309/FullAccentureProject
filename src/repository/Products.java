package repository;

import classes.Building;
import classes.Product;
import classes.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Products extends BaseTable{
    public static ArrayList<Product> getProducts (Building building){
        ArrayList<Product> list = new ArrayList<>();
        ResultSet products;
        Product product;
        try {
            products = getDataSQL("SELECT * FROM PRODUCTS WHERE BUILDING_ID = (SELECT ID FROM BUILDINGS WHERE NAME = '"+building.getName()+"')");
            while (products.next()){
                list.add(makeProduct(products, building));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static void changeLocation(Product product, Building newBuilding){
        try {
            modifyDatabase("UPDATE PRODUCTS SET BUILDING_ID = "+newBuilding.getId()+" WHERE ID="+product.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static Product createNewProduct(Building building, User user){
        ResultSet result;
        Product product = new Product();
        try {
            int userId;
            {
                ResultSet currentUser = getDataSQL("SELECT ID FROM USERS WHERE USERNAME='" + user.getUsername() + "' AND PASSWORD='" + user.getPassword() + "'");
                currentUser.next();
                userId = currentUser.getInt("ID");
            }
            int shiftId;
            {
                ResultSet shift = getDataSQL("SELECT ID FROM SHIFTS WHERE SHIFT_NAME='"+user.getShift()+"'");
                shift.next();
                shiftId = shift.getInt("ID");
            }
            Random rnd = new Random();
            String sql = "INSERT INTO PRODUCTS (BUILDING_ID, USER_ID, SHIFT_ID, PRODUCT_TYPE, PRICE, DATEANDTIME, IS_DEFECT) " +
                    "VALUES (" +
                     building.getId() + ", " +
                     userId + ", " +
                     shiftId + ", " +
                     "'" + Product.getType() + "'" + ", " +
                     Product.getPrice() + ", " +
                     "NOW(), " +
                    (rnd.nextDouble() <= user.getEfficiency()?"false":"true")+")";
            modifyDatabase(sql);
            result = getDataSQL("SELECT * FROM PRODUCTS ORDER BY ID DESC LIMIT 1");
            product = makeProduct(result, building);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
    static Product makeProduct(ResultSet result, Building building){
        Product product = new Product();
        try {
            if(result.isBeforeFirst()){
                result.next();
            }
            product = new Product();
            product.setId(result.getInt("ID"));
            product.setBuilding(building);
            {
                int shiftId = result.getInt("SHIFT_ID");
                ResultSet shift = getDataSQL("SELECT * FROM SHIFTS WHERE ID = " + shiftId);
                shift.next();
                product.setShift(shift.getString("SHIFT_NAME"));
            }
            product.setDateAndTime(result.getTimestamp("DATEANDTIME"));
            product.setIsDefect(result.getBoolean("IS_DEFECT"));
            product.setUser(Users.getUser(product));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
    public static void deleteProduct(Product product){
        try {
            modifyDatabase("DELETE FROM PRODUCTS WHERE ID = "+product.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
