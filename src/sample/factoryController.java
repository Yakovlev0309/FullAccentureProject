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
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
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
    private Tab productTab;

    @FXML
    public Tab userTab;

    @FXML
    public Button backBtn;

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<Product, Integer> idClmn;

    @FXML
    private TableColumn<Product, String> typeClmn;

    @FXML
    private TableColumn<Product, Double> priceClmn;

    @FXML
    private TableColumn<Product, String> pShiftClmn;

    @FXML
    private TableColumn<Product, Boolean> defectClmn;

    @FXML
    private TableColumn<Product, String> pNameClmn;

    @FXML
    private TableColumn<Product, Timestamp> dateClmn;

    @FXML
    private TableColumn<User, String> nameClmn;

    @FXML
    private TableColumn<User, String> surnameClmn;

    @FXML
    private TableColumn<User, String> passwordClmn;

    @FXML
    private TableColumn<User, String> usernameClmn;

    @FXML
    private TableColumn<User, String> shiftClmn;

    @FXML
    private TableColumn<User, String> efficiencyClmn;

    private User user;

    @FXML
    void initialize() {

        backBtn.setOnAction(event -> {
//            backBtn.getScene().getWindow().hide();
//
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/sample/general.fxml"));
//
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setTitle("Главное меню");
//            stage.setScene(new Scene(root, 1109, 555));
//            stage.show();
            FXMLLoader loader = new FXMLLoader();
            Parent root;
            Stage stage = new Stage();
            loader.setLocation(getClass().getResource("/sample/general.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            generalController gC = loader.getController();
            gC.SetUser(user);
            root = loader.getRoot();
            stage.setTitle("Главное меню");
            stage.setScene(new Scene(root, 1109, 555));
            stage.show();
        });
    }

    public void SetUser(User user) {
        this.user = user;
        UpdateTable();
    }

    public void UpdateTable(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        ArrayList<Product> prods = user.getBuilding().getProducts();
        products.addAll(prods);
        //table = new TableView<>(products);
        //idClmn = new TableColumn<Product, Integer>("ID");
        idClmn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));// имя переменной класса Product
        pNameClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("user"));
        pShiftClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("shift"));
        typeClmn.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));
        priceClmn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        dateClmn.setCellValueFactory(new PropertyValueFactory<Product, Timestamp>("dateAndTime"));
        defectClmn.setCellValueFactory(new PropertyValueFactory<Product, Boolean>("isDefect"));
        //table.getColumns().add(idClmn);
        productTable.setItems(products);
    }
}