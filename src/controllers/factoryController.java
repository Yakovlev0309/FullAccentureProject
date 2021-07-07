package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
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
import repository.Buildings;
import classes.Building;
import classes.Facade;
import classes.Product;
import classes.User;

public class factoryController extends BuildingController implements EnhancedController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab productTab;

//    @FXML
//    public Tab userTab;
//
//    @FXML
//    public Button backBtn;
    //region Товары {...}
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> idClmn;
    @FXML
    private TableColumn<Product, String> ptypeClmn;
    @FXML
    private TableColumn<Product, Double> priceClmn;
    @FXML
    private TableColumn<Product, Boolean> defectClmn;
    @FXML
    private TableColumn<Product, String> pShiftClmn;
    @FXML
    private TableColumn<Product, String> pNameClmn;
    @FXML
    private TableColumn<Product, Timestamp> dateClmn;
    //endregion

    //region Пользователи {...}
    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, String> nameClmn;
    @FXML
    private TableColumn<User, String> surnameClmn;
    @FXML
    private TableColumn<User, String> typeClmn;
    @FXML
    private TableColumn<User, String> usernameClmn;
    @FXML
    private TableColumn<User, String> passwordClmn;
    @FXML
    private TableColumn<User, String> shiftClmn;
    @FXML
    private TableColumn<User, String> efficiencyClmn;
    //endregion

//    private User user;


    @FXML
    private Button exitBtn;

    ObservableList<Product> products = FXCollections.observableArrayList();
    ObservableList<User> users = FXCollections.observableArrayList();

    ObservableList<Building> buildings = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        idClmn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));// имя переменной класса Product
        ptypeClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));
        priceClmn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        defectClmn.setCellValueFactory(new PropertyValueFactory<Product, Boolean>("isDefect"));
        pShiftClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("shift"));
        pNameClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("user"));
        dateClmn.setCellValueFactory(new PropertyValueFactory<Product, Timestamp>("dateAndTime"));

        nameClmn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameClmn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        typeClmn.setCellValueFactory(new PropertyValueFactory<>("type"));
        usernameClmn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordClmn.setCellValueFactory(new PropertyValueFactory<>("password"));
        shiftClmn.setCellValueFactory(new PropertyValueFactory<>("shift"));
        efficiencyClmn.setCellValueFactory(new PropertyValueFactory<>("efficiency"));

        productTable.setItems(products);
        userTable.setItems(users);

        buildings.setAll(Buildings.getBuildings("storage"));
        buildingsComboBox.setItems(buildings);

        backBtn.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader();
            Parent root;
            Stage stage = new Stage();
            loader.setLocation(getClass().getResource("/controllers/general.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            backBtn.getScene().getWindow().hide();
            //todo заменить на EnhancedController
            generalController gC = loader.getController();
            gC.setUser(user);
            root = loader.getRoot();
            stage.setTitle("Главное меню");
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        });
        exitBtn.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            Parent root;
            Stage stage = new Stage();
            loader.setLocation(getClass().getResource("/controllers/sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            exitBtn.getScene().getWindow().hide();
            root = loader.getRoot();
            stage.setTitle("Авторизация");
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        });
        actionBtn.setOnAction(event -> {
            Facade.makeNewProduct(user.getBuilding(), user);
            updateTable();
        });

        sendBtn.setOnAction(event -> {
            TableView.TableViewSelectionModel<Product> model = productTable.getSelectionModel();
            Product product = model.getSelectedItem();
            Building building = buildingsComboBox.getValue();
            if(product != null && building != null){
                user.getBuilding().sendTo(building, product);
            }
            updateTable();
        });
    }

    public void updateTable(){
        products.setAll(user.getBuilding().getProducts());
        users.setAll(user.getBuilding().getUsers());
    }
}