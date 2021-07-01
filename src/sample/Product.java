package sample;

import repository.Products;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;

public class Product {
    //Уникальный номер для каждого продукта
    private int id;
    private Building building;
    //private User user;
    private String shift;//смена, когда было произведено
    private static final String type = "product";
    private static final double price = 45.5;
    private Timestamp dateAndTime;//время производства
    private boolean isDefect;

    //region Геттеры и сеттеры {...}
    //Метод доступа к уникальному номеру
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public static String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Timestamp getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Timestamp dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public boolean isDefect() {
        return isDefect;
    }

    public void setDefect(boolean defect) {
        isDefect = defect;
    }
    //endregion

    public Product(int id) {
        this.id = id;
    }

    public Product(){}

    public void deleteProduct(){
        Products.deleteProduct(this);
    }

    public void SetNewLocation(Building building) {
        Products.changeLocation(this, building);
    }
}
