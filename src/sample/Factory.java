package sample;

import repository.Products;

public class Factory extends Building {

    public static final String type = "factory";

    public Factory(){super();}

    public void createProducts(User user, int count){
        products.add(Products.createNewProduct(this, user, count));
    }
}

