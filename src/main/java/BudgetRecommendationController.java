import com.sun.tools.javac.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.Objects;

public class BudgetRecommendationController {

    @FXML
    private BorderPane root5; // access to BorderPane in FXML file
    //Buttons -----------------------------------
    @FXML
    private Button conservativeButton;

    @FXML
    private Button moderateButton;

    @FXML
    private Button aggressiveButton;

    // Labels -------------------------
    @FXML
    private Label BudgetingName;
    @FXML
    public Label currentSalary;

    // Define budget categories
    @FXML
    private Label housingRec;
    @FXML
    private Label groceriesRec;
    @FXML
    private Label personalCareRec;
    @FXML
    private Label transportationRec;
    @FXML
    private Label diningRec;
    @FXML
    private Label entertainmentRec;
    // TextField -------------------------
    @FXML
    private TextField modifySalary;
    @FXML
    private TextField modifyHousingPay;
    // Variables for backend ----------------
    private double currentRent = 700.0;

    public void initialize() {
        // Add a FocusListener to the text field when the controller is initialized.
        modifySalary.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Check if the text field lost focus
                String newSalary = modifySalary.getText();
                if (!newSalary.isEmpty()) {
                    currentSalary.setText(newSalary);
                }
            }
        });

        modifyHousingPay.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Check if the text field lost focus
                String newRent = modifyHousingPay.getText();
                if (!newRent.isEmpty()) {
                    currentRent = Double.valueOf(newRent);
                }
            }
        });
    }

    public Integer getCurrentSalary() {
        return Integer.valueOf(currentSalary.getText());
    }


    @FXML
    private void conservativeRecommendation(ActionEvent event) {
        // Implement the conservative budget plan
        calculateConservativeBudget();
        // Update the recommendation label
        updateRecommendationLabel("Conservative Budget Recommendation");
    }

    @FXML
    private void moderateRecommendation(ActionEvent event) throws IOException {
        // Implement the moderate budget plan
        calculateModerateBudget();
        // Update the recommendation label
        updateRecommendationLabel("Moderate Budget Recommendation");

    }

    @FXML
    private void aggressiveRecommendation(ActionEvent event) {
        // Implement the aggressive budget plan
        calculateAggressiveBudget();
        // Update the recommendation label
        updateRecommendationLabel("Aggressive Budget Recommendation");
    }
    
    @FXML 
    private void goBackHome(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/HomeScreen.fxml"));
    	root.setStyle("-fx-font-family: 'serif'");
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root5.getScene().getWindow();;
        primaryStage.setScene(s1);
        primaryStage.show();	
    }

    // Helper method to calculate conservative budget
    private void calculateConservativeBudget() {
        // Calculating Moderate Budget Based On Salary
        String salary = currentSalary.getText();
        double housing = (Double.parseDouble(salary) * .04) + currentRent;
        int housingInt = (int) housing; // Convert to integer

        double groceries = Double.parseDouble(salary) * .10;
        int groceriesInt = (int) groceries; // Convert to integer

        double personalCare = Double.parseDouble(salary) * .05;
        int personalCareInt = (int) personalCare; // Convert to integer

        double transportation = Double.parseDouble(salary) * .08;
        int transportationInt = (int) transportation; // Convert to integer

        double dining = Double.parseDouble(salary) * .10;
        int diningInt = (int) dining; // Convert to integer

        double entertainment = Double.parseDouble(salary) * .06;
        int entertainmentInt = (int) entertainment; // Convert to integer

        housingRec.setText(String.valueOf(housingInt));
        groceriesRec.setText(String.valueOf(groceriesInt));
        personalCareRec.setText(String.valueOf(personalCareInt));
        transportationRec.setText(String.valueOf(transportationInt));
        diningRec.setText(String.valueOf(diningInt));
        entertainmentRec.setText(String.valueOf(entertainmentInt));
    }

    // Helper method to calculate moderate budget
    private void calculateModerateBudget() throws IOException {
        // Calculating Moderate Budget Based On Salary
        String salary = currentSalary.getText();
        double housing = (Double.parseDouble(salary) * .05) + currentRent;
        int housingInt = (int) housing; // Convert to integer

        double groceries = Double.parseDouble(salary) * .15;
        int groceriesInt = (int) groceries; // Convert to integer

        double personalCare = Double.parseDouble(salary) * .06;
        int personalCareInt = (int) personalCare; // Convert to integer

        double transportation = Double.parseDouble(salary) * .10;
        int transportationInt = (int) transportation; // Convert to integer

        double dining = Double.parseDouble(salary) * .15;
        int diningInt = (int) dining; // Convert to integer

        double entertainment = Double.parseDouble(salary) * .10;
        int entertainmentInt = (int) entertainment; // Convert to integer

        housingRec.setText(String.valueOf(housingInt));
        groceriesRec.setText(String.valueOf(groceriesInt));
        personalCareRec.setText(String.valueOf(personalCareInt));
        transportationRec.setText(String.valueOf(transportationInt));
        diningRec.setText(String.valueOf(diningInt));
        entertainmentRec.setText(String.valueOf(entertainmentInt));
    }

    // Helper method to calculate aggressive budget
    private void calculateAggressiveBudget() {
        // Calculating Moderate Budget Based On Salary
        String salary = currentSalary.getText();
        double housing = (Double.parseDouble(salary) * .03) + currentRent;
        int housingInt = (int) housing; // Convert to integer

        double groceries = Double.parseDouble(salary) * .07;
        int groceriesInt = (int) groceries; // Convert to integer

        double personalCare = Double.parseDouble(salary) * .04;
        int personalCareInt = (int) personalCare; // Convert to integer

        double transportation = Double.parseDouble(salary) * .05;
        int transportationInt = (int) transportation; // Convert to integer

        double dining = Double.parseDouble(salary) * .05;
        int diningInt = (int) dining; // Convert to integer

        double entertainment = Double.parseDouble(salary) * .02;
        int entertainmentInt = (int) entertainment; // Convert to integer

        housingRec.setText(String.valueOf(housingInt));
        groceriesRec.setText(String.valueOf(groceriesInt));
        personalCareRec.setText(String.valueOf(personalCareInt));
        transportationRec.setText(String.valueOf(transportationInt));
        diningRec.setText(String.valueOf(diningInt));
        entertainmentRec.setText(String.valueOf(entertainmentInt));
    }

    // Helper method to update the recommendation label
    private void updateRecommendationLabel(String recommendation) {
        BudgetingName.setText(recommendation);
    }


}
