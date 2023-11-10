import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TransactionsController implements Initializable {
    //Panes
    @FXML
    private BorderPane root4; // access to BorderPane in FXML file
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void HomeButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/HomeScreen.fxml"));
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root4.getScene().getWindow();;
        primaryStage.setScene(s1);
        primaryStage.show();
    }
}
