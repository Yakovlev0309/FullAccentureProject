package sample;

import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class Building {
    private ArrayList<Product> products;
    private String type;
    public Building() {
        products = new ArrayList<>();
    }
    public Building(ResultSet result) {
        //присвоение данных из БД
        //type = ...;
        products = new ArrayList<>();
    }
    public String Type() {
        return type;
    }
    public ArrayList<Product> Products() {
        return products;
    }
    public int CountOfProducts() {
        return products.size();
    }
    public abstract void AddProducts(int count);
    public abstract void SendTo(Building building, int count);
}
