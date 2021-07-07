package classes;

import java.util.ArrayList;

public class Building {

    protected ArrayList<Product> products;
    protected ArrayList<User> users;
    protected int id;
    protected String type;
    protected String name;

    public Building() {
        products = new ArrayList<>();
    }

    //region Сеттеры и геттеры {...}
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
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
    //endregion

    public int CountOfProducts() {
        return products.size();
    }

    public void addProduct(Product product){
        products.add(product);
    }
    //public void removeProduct(){products.remove(0);}

    public void sendTo(Building building, Product product){
        products.remove(product);
        product.setNewLocation(building);
        building.products.add(product);
    }
    public void deleteProduct(Product product){
        product.deleteProduct();
        products.remove(product);
    }
    @Override
    public String toString(){
        return name;
    }
}
