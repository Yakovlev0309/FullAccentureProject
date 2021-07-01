package sample;

import repository.Database;
import repository.Users;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String type;
    private Building building;
    private String shift; // смена работника
    private Double efficiency; //вероятность сделать без брака
    private String name;
    private String surname;

    public User(){}

    //region Геттеры и сеттеры {...}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Double efficiency) {
        this.efficiency = efficiency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    //endregion

    @Override
    public String toString(){
        return name+" "+surname;
    }

    //region Тестовый метод {...}
    public static void main (String[] args){
        try {
            Database db = new Database();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        User user = Users.getUser("store2worker","worker");
        Building building = user.getBuilding();
        ArrayList<Product> products = building.getProducts();
        System.out.println(user);
    }
    //endregion
}