package sample;

import repository.Buildings;
import repository.Database;
import repository.Users;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String type;
    private Building building;
    private String shift; // смена работника
    private Double efficiency; //вероятность сделать без брака

    public User(){}

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

    @Override
    public String toString(){
        return "User {username = "+username+"; password = "+password+"; type = "+type+";}";
//        return "User\n" +
//                username+"\n" +
//                password+"\n" +
//                type+"\n";
    }
    public static void main (String[] args){
        try {
            Database db = new Database();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        User user = Users.GetUser("store2worker","worker");
        Building building = user.getBuilding();
        ArrayList<Product> products = building.getProducts();
        System.out.println(user);
    }
}