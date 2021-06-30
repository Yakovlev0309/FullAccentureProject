package sample;

import repository.Products;

public class Product {
    //Уникальный номер для каждого продукта
    private int id;

    //Метод доступа к уникальному номеру
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
