package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class factoryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backBtn;

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product, Integer> idClmn;

    @FXML
    private TableColumn<Product, String> userClmn;

    @FXML
    private TableColumn<Product, String> shiftClmn;

    @FXML
    private TableColumn<Product, String> typeClmn;

    @FXML
    private TableColumn<Product, Double> priceClmn;

    @FXML
    private TableColumn<Product, Timestamp> dateClmn;

    @FXML
    private TableColumn<Product, Boolean> defectClmn;

    private Building building;

    @FXML
    void initialize() {
        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/general.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Главное меню");
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        });
        //Обращение к ячейкам

    }

    public void SetBuilding(Building building) {
        this.building = building;
        ObservableList<Product> products = FXCollections.observableArrayList();
        ArrayList<Product> prods = building.getProducts();
        products.addAll(prods);
        //table = new TableView<>(products);//новая таблица
        //idClmn = new TableColumn<Product, Integer>("ID");//новая колонка

        //связывание колонки и данных класса с помощью фабрики
        idClmn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));// имя переменной класса Product
        userClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("user"));
        shiftClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("shift"));
        typeClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));
        priceClmn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        dateClmn.setCellValueFactory(new PropertyValueFactory<Product, Timestamp>("dateAndTime"));
        defectClmn.setCellValueFactory(new PropertyValueFactory<Product, Boolean>("isDefect"));
        //table.getColumns().add(idClmn);
        table.setItems(products);
    }
}