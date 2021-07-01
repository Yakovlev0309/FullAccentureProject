package repository;

import sample.Building;
import sample.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Products extends BaseTable{
    public static ArrayList<Product> getProducts (Building building){
        ArrayList<Product> list = new ArrayList<>();
        ResultSet products;
        Product product = new Product();
        try {
            products = getDataSQL("SELECT * FROM PRODUCTS WHERE BUILDING_ID = (SELECT ID FROM BUILDINGS WHERE NAME = '"+building.getName()+"')");
            while (products.next()){
                //product = new Product(products.getInt("ID"));
                product.setId(products.getInt("ID"));
                product.setBuilding(building);
                product.setShift(products.getString("SHIFT_NAME"));
                product.setDateAndTime(products.getTimestamp("DATEANDTIME"));
                product.setDefect(products.getBoolean("IS_DEFECT"));
                //product.setUser(Users.getUser(product));
                list.add(product);
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
    public static Product createNewProduct(Building building){
        ResultSet result;
        Product product = new Product();
        try {
            modifyDatabase("INSERT INTO PRODUCTS (BUILDING_ID) VALUES("+building.getId()+")");
            result = getDataSQL("SELECT * FROM PRODUCTS ORDER BY ID DESC LIMIT 1");
            product.setId(result.getInt("ID"));
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
