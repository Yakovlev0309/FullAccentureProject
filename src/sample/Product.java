package sample;

import repository.Products;

import java.sql.Timestamp;

public class Product {
    //Уникальный номер для каждого продукта
    private int id;
    private Building building;
    private String user;//имя и фамилия
    private String shift;//смена, когда было произведено
    private static final String type = "product";
    private static final double price = 45.5;
    private Timestamp dateAndTime;//время производства
    private boolean isDefect;//можно в виде строки "Да"/"Нет"

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public static String getType() {
        return type;
    }

    public static double getPrice() {
        return price;
    }

    public Timestamp getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Timestamp dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public boolean getIsDefect() {
        return isDefect;
    }

    public void setIsDefect(boolean defect) {
        isDefect = defect;
    }
    //endregion

//    public Product(int id) {
//        this.id = id;
//    }

    public Product(){}

    public void deleteProduct(){
        Products.deleteProduct(this);
    }

    public void setNewLocation(Building building) {
        Products.changeLocation(this, building);
    }
}
