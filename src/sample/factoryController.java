package sample;

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
        ObservableList<User> users = FXCollections.observableArrayList();

        products.addAll(user.getBuilding().getProducts());
        users.addAll(user.getBuilding().getUsers());

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
    }
}