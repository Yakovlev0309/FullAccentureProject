package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class shopController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab shop1Btn;

    @FXML
    private TableColumn<?, ?> artClmn;

    @FXML
    private TableColumn<?, ?> nameClmn;

    @FXML
    private TableColumn<?, ?> countClmn;

    @FXML
    private TableColumn<?, ?> priceClmn;

    @FXML
    private Button backBtn;

    @FXML
    private Tab shop2Btn;

    @FXML
    private Tab shop3Btn;

    private Building building;

    @FXML
    void initialize() {
        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/general.fxml"));

            try {
                loader.load();
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