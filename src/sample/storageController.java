package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class storageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backBtn;

    @FXML
    private TitledPane TitledPane;

    @FXML
    private TableView<?> Table;

    @FXML
    private TableColumn<?, ?> TableProd;

    @FXML
    private TableColumn<?, ?> TableCount;

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

    }
    public void SetBuilding(Building building) {
        this.building = building;
    }
}