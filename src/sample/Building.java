package sample;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Building {

    protected ArrayList<Product> products;
    protected int id;
    protected String type;
    protected String name;

    public Building() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int CountOfProducts() {
        return products.size();
    }

    public void addProduct(Product product){
        products.add(product);
    }
    //public void removeProduct(){products.remove(0);}

    public void sendTo(Building building, int count){
        for(int i = 0; i < count; i++){
            building.addProduct(products.get(0));
            products.get(0).SetNewLocation(building);
            products.remove(0);
        }
    }

    @Override
    public String toString(){
        return name;
    }
}
