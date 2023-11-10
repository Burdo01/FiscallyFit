

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


// My controller class is used to make the buttons and text fields interactive
public class MyController implements Initializable {

    //Panes
    @FXML
    private BorderPane root2; // access to BorderPane in FXML file


    ///HomeScreen Buttons
    @FXML
    private Button settingsButton;
    @FXML
    private Button dayButton;
    @FXML
    private Button weekButton;
    @FXML
    private Button monthButton;
    @FXML
    private Button yearButton;
    @FXML
    private Button manageButton;
    @FXML
    private Button cardButton;
    @FXML
    private Button breakDownButton;

    

    //static so each instance of controller can access to update
    private static String textEntered = "";
    @FXML
    private Text textTransactionOne;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        textName.setText("Welcome back...");
        //fillName();
        try {
            fillBudget();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fillTransactions();
    }
    // Home Scene Events
    public void gotoSettings(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/SettingsScene.fxml"));
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root2.getScene().getWindow(); // Assuming root1 is the root of your current scene
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    public void manageBudgeting(ActionEvent actionEvent) throws IOException {
        manageButton.setDisable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/BudgettingRecommendationsScreen.fxml"));
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root2.getScene().getWindow(); // Assuming root1 is the root of your current scene
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    public void viewCardInfo(ActionEvent actionEvent) throws IOException {

    }


    public void seeTransactionBreakdown(ActionEvent actionEvent) throws IOException{
        breakDownButton.setDisable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/TransactionScreen.fxml"));
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root2.getScene().getWindow(); // Assuming root1 is the root of your current scene
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    /// Dynamic Transactions for Home Scene ______________________________________________________
    @FXML
    private Text textName;
    @FXML
    private Text textBudgetLeft;
    // @FXML
    //private Text textTransactionOne;
    @FXML
    private Text textTransactionTwo;
    @FXML
    private Text textTransactionThree;
    @FXML
    private Text textTransactionFour;
    @FXML
    private Text textTransactionFive;
    @FXML
    private Text textTransactionSix;
    @FXML
    private Text textTransactionSeven;
    @FXML
    private Text textTransactionEight;
    @FXML
    private Text textTransactionNine;
    
    int filled = 0;

    ArrayList<String> holdTransactions = new ArrayList<>();

    Boolean dayButtonPressed = false;
    Boolean weekButtonPressed = false;
    Boolean monthBUttonPressed = false;
    Boolean yearButtonPressed = false;


    @FXML
    public void fillName() {
        textName.setText(RandomUserGenerator.generateName());
    }
    @FXML
    public void fillTransactions() {

    	if(filled != 1) {
    		textTransactionOne.setText(RandomUserGenerator.generateTransaction());
            holdTransactions.add(textTransactionOne.getText());
    		textTransactionTwo.setText(RandomUserGenerator.generateTransaction());
            holdTransactions.add(textTransactionTwo.getText());
    		textTransactionThree.setText(RandomUserGenerator.generateTransaction());
            holdTransactions.add(textTransactionThree.getText());
    		textTransactionFour.setText(RandomUserGenerator.generateTransaction());
            holdTransactions.add(textTransactionFour.getText());
    		textTransactionFive.setText(RandomUserGenerator.generateTransaction());
            holdTransactions.add(textTransactionFive.getText());
    		textTransactionSix.setText(RandomUserGenerator.generateTransaction());
            holdTransactions.add(textTransactionSix.getText());
    		textTransactionSeven.setText(RandomUserGenerator.generateTransaction());
            holdTransactions.add(textTransactionSeven.getText());
    		textTransactionEight.setText(RandomUserGenerator.generateTransaction());
            holdTransactions.add(textTransactionEight.getText());
    		textTransactionNine.setText(RandomUserGenerator.generateTransaction());
            holdTransactions.add(textTransactionNine.getText());

    		filled = 1;
    	}
    	else {
    		return;
    	}
    }
    
    @FXML
    public void fillBudget() throws IOException {


        textBudgetLeft.setText(RandomUserGenerator.generateBudget());

    }

    void clearTransactions(){
        textTransactionOne.setText("");
        textTransactionTwo.setText("");
        textTransactionThree.setText("");
        textTransactionFour.setText("");
        textTransactionFive.setText("");
        textTransactionSix.setText("");
        textTransactionSeven.setText("");
        textTransactionEight.setText("");
        textTransactionNine.setText("");

        filled = 0;
    }

    public void dayBudgeting(ActionEvent actionEvent) throws IOException {
        // SetDisable for Buttons
        yearButton.setDisable(false);
        monthButton.setDisable(false);
        dayButton.setDisable(true);
        weekButton.setDisable(false);

        // Setting Button Styles
        dayButton.setStyle("-fx-background-color: lightblue");
        monthButton.setStyle("");
        weekButton.setStyle("");
        yearButton.setStyle("");

        // Setting Transactions
        clearTransactions();
        textTransactionOne.setText(holdTransactions.get(0));
        textTransactionTwo.setText(holdTransactions.get(1));


        dayButtonPressed = true;
    }

    public void weekBudgeting(ActionEvent actionEvent) throws IOException {
        // SetDisable for Buttons
        yearButton.setDisable(false);
        monthButton.setDisable(false);
        dayButton.setDisable(false);
        weekButton.setDisable(true);

        // Setting Button Styles
        weekButton.setStyle("-fx-background-color: lightblue");
        monthButton.setStyle("");
        dayButton.setStyle("");
        yearButton.setStyle("");

        // Setting Transactions
        clearTransactions();
        textTransactionOne.setText(holdTransactions.get(0));
        textTransactionTwo.setText(holdTransactions.get(1));
        textTransactionThree.setText(holdTransactions.get(2));
        textTransactionFour.setText(holdTransactions.get(3));
    }

    public void monthBudgeting(ActionEvent actionEvent) throws IOException {
        // SetDisable for Buttons
        yearButton.setDisable(false);
        monthButton.setDisable(true);
        dayButton.setDisable(false);
        weekButton.setDisable(false);

        // Setting Button Styles
        monthButton.setStyle("-fx-background-color: lightblue");
        dayButton.setStyle("");
        weekButton.setStyle("");
        yearButton.setStyle("");

        // Setting Transactions
        clearTransactions();
        textTransactionOne.setText(holdTransactions.get(0));
        textTransactionTwo.setText(holdTransactions.get(1));
        textTransactionThree.setText(holdTransactions.get(2));
        textTransactionFour.setText(holdTransactions.get(3));
        textTransactionFive.setText(holdTransactions.get(4));

    }

    public void yearBudgeting(ActionEvent actionEvent) throws IOException {
        // SetDisable for Buttons
        monthButton.setDisable(false);
        dayButton.setDisable(false);
        weekButton.setDisable(false);
        // Disable the yearButton
        yearButton.setDisable(true);

        // Button Styles
        yearButton.setStyle("-fx-background-color: lightblue");
        monthButton.setStyle("");
        dayButton.setStyle("");
        weekButton.setStyle("");

        // Set transactions
        clearTransactions();
        textTransactionOne.setText(holdTransactions.get(0));
        textTransactionTwo.setText(holdTransactions.get(1));
        textTransactionThree.setText(holdTransactions.get(2));
        textTransactionFour.setText(holdTransactions.get(3));
        textTransactionFive.setText(holdTransactions.get(4));
        textTransactionSix.setText(holdTransactions.get(5));
        textTransactionSeven.setText(holdTransactions.get(6));
        textTransactionEight.setText(holdTransactions.get(7));
        textTransactionNine.setText(holdTransactions.get(8));
    }


}
