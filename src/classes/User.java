package classes;

import repository.Database;
import repository.Users;

import java.util.ArrayList;
import java.util.Random;

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

    public  User(Building building, String type, String username, String password, Integer shiftId, String name, String surname){
        this.building = building;
        this.type = type;
        this.username = username;
        this.password = password;
        switch (shiftId){
            case 1:
                shift = "1-ая";
                break;
            case  2:
                shift = "2-ая";
                break;
        }
        this.name = name;
        this.surname = surname;
        Random rnd = new Random();
        efficiency = Math.round(rnd.nextDouble() * 0.099 * 1000) / 1000  + 0.9;
    }

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

    public void createNewUser(){Users.createNewUser(this);}

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