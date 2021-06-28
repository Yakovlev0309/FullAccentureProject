package sample;

public class Product {
    //Уникальный номер для каждого продукта
    private int id;
    public Product(int id) {
        this.id = id;
    }
    //Метод доступа к уникальному номеру
    public int GetId() {
        return id;
    }
    public void SetNewLocation(Building building) {
        //Products.ChangeLocation(this, building);
    }
}
