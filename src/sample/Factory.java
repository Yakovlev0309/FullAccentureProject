package sample;

import java.sql.ResultSet;

public class Factory extends Building {
    @Override
    public void AddProducts(int count) {
        for (byte i = 0; i < count; i++) {
            //Производим товары
        }
    }
    @Override
    public void SendTo(Building building, int count) {
        for (byte i = 0; i < count; i++) {
            building.Products().add(Products().get(i));
            Products().remove(0);
            Products().get(i).SetNewLocation(building);
        }
    }
}

