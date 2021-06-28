package sample;

import java.util.ArrayList;

public class Store extends Building {
    @Override
    public void AddProducts(int count) {
        for (byte i = 0; i < count; i++) {
            //Берём товары со склада
        }
    }
    @Override
    public void SendTo(Building building, int count) {
        //Zdes nichego ne proishodit
    }
}
