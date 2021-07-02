package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class storageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Tab prodTab;

    @FXML
    private URL location;

    @FXML
    private Button backBtn;

    @FXML
    private TitledPane TitledPane;

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product, Integer> artClmn;

    @FXML
    private TableColumn<Product, String> nameClmn;

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

    @FXML
    private Button backBtn2;

    @FXML
    private Tab staffTab;

    @FXML
    private Button backBtn1;

    @FXML
    private TableView<?> table2;

    @FXML
    private TableColumn<?, ?> priorityClmn2;

    @FXML
    private TableColumn<?, ?> planClmn2;

    @FXML
    private TableColumn<?, ?> nameClmn2;

    private Building building;

    @FXML
    void initialize() {
        backBtn1.setOnAction(event -> {
            backBtn1.getScene().getWindow().hide();

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

        backBtn2.setOnAction(event -> {
            backBtn2.getScene().getWindow().hide();

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

    }
    public void SetBuilding(Building building) {
        this.building = building;
        UpdateTable();
    }
    public void UpdateTable(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        ArrayList<Product> prods = building.getProducts();
        products.addAll(prods);
        //table = new TableView<>(products);
        //idClmn = new TableColumn<Product, Integer>("ID");
        artClmn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));// имя переменной класса Product
        nameClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("user"));
        shiftClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("shift"));
        typeClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));
        priceClmn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        dateClmn.setCellValueFactory(new PropertyValueFactory<Product, Timestamp>("dateAndTime"));
        defectClmn.setCellValueFactory(new PropertyValueFactory<Product, Boolean>("isDefect"));
        //table.getColumns().add(idClmn);
        table.setItems(products);
    }
}