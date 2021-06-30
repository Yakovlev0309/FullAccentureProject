package sample;

import java.util.ArrayList;

public class Store extends Building {

    public static final String type = "store";

    public Store(){super();}

    public void sellProducts(int count){
       for(int i = 0; i < count; i++){
           products.get(0).deleteProduct();
           products.remove(0);
       }
    }
}
