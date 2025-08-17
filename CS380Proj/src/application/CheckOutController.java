package application;
/**
    CheckOutController
    Date of code: 8/13/25
    This controller class handles all of the UI elements of the CheckOut page
    This includes things like verify if credit card is valid or getting the customer information
    @author Nery Armaz
*/

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;
import java.util.ArrayList;
import Company.products.product;
import Company.products;
import Company.customer;
import Company.inventory;
import application.CreditCardValidation;
import Company.ShoppingCart;


import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckOutController extends SceneController/*implements Initializable*/{
    /**
        Button to navigate to the keyboards page
    */
    @FXML private Button btnKeyboards;
    /**
        Button to navigate to the keycaps page
    */
    @FXML private Button btnKeycaps;
    /**
        Button to navigate to the switches page
    */
    @FXML private Button btnSwitches;
    /**
        Button to navigate to the shopping cart page
    */
    @FXML private Button btnCart;
    /**
        Button to navigate to the account user page
    */
    @FXML private Button btnAccount;

    /**
        Button to navigate to the keycaps page
    */
    @FXML private Button btnKeyCaps;
    
    /**
        Returns user to the home page
    */
    @FXML private Button logoBtn;
    
    /**
        Places all labels and textfields in it
    */
    @FXML private GridPane grid;
    
    /**
     * Button that runs the credit card verification program
     */
    @FXML private Button btnPayNow;
    
    /**
     * For entering customer first name
     */
    @FXML private TextField customerFirstName;
    
    /**
     * For entering customer last name
     */
    @FXML private TextField customerLastName;
    
    /**
     * For entering customer email
     */
    @FXML private TextField customerEmail;
    
    /**
     * For entering customer phone number
     */
    @FXML private TextField customerPhoneNum;
    
    /**
     * For entering customer street address
     */
    @FXML private TextField customerAddress;
    
    /**
     * For entering customer card number
     */
    @FXML private TextField cardNumber;
    
    /**
     * For entering customer card CVC
     */
    @FXML private TextField cardCVC;
    
    /**
     * For entering customer card expiration month
     */
    @FXML private TextField cardExpMonth;
    
    /**
     * For entering customer card expiration year
     */
    @FXML private TextField cardExpYear;
    
    /**
     * Label outputs if payment process was a success or not
     */
    @FXML private Label paymentProcessResult;
    
    /**
     * Button is if customer wants to return to home page during the payment process
     */
    @FXML private Button btnBackHome;
    
//    /**
//     * The free shipping method available to user
//     */
//    @FXML private RadioButton optionFree;
//    
//    /**
//     * The standard shipping method available to user
//     */
//    @FXML private RadioButton optionStandard;
//    
//    /**
//     * The express shipping method available to user
//     */
//    @FXML private RadioButton optionExpress;
//    
//    /**
//     * The group name for the radio buttons
//     */
//    @FXML private ToggleGroup shippingOptions;
//    /**
//        Managing the main application window
//    */
//    private Stage stage;
//    /**
//        Switching between the FXML views
//    */
//    private Scene scene;
//    /**
//        Root node in loading the new FXML
//    */
//    private Parent root;
    
    /**
     * An object of the CreditCardValidation class in order to use isValidCard method
     */
    private CreditCardValidation validate;
    
    /**
     * This list holds all of the customers that will make a purchase
     */
    private List<customer> customers = new ArrayList<>();
    
    /**
     * Integer for the customer ID
     */
    private int customerCount = 0;
    
    /**
     * Constructor for the CheckOutController class
     */
    public CheckOutController() {}
    
    /**
     * Method that updates the customer ID
     */
    private int update() {
    	return ++customerCount;
    }
    
    /**
     * Returns the string of the shipping method selected
     * @return Returns a string 
     */
//    private String getShipping() {
//    	String shippingMethod;
//    	RadioButton picked = (RadioButton) shippingOptions.getSelectedToggle();
//    	if (picked != null) {
//    		shippingMethod = picked.getText();
//    	} else {
//    		shippingMethod = null;
//    	}
//    	return shippingMethod;
//    }
    
    /**
     * Triggered when btnPayNow is clicked, it verified if all fields on this page are valid
     * @param event Waits and expects a button click on btnPayNow
     */
    public void VerifyPaymentProcess(ActionEvent event) {
    	//String shipping = getShipping();
    	System.out.println(inventory.getAllProducts());
    	System.out.println(inventory.getAllKeyboards());
    	System.out.println(inventory.getallKeycaps());
    	System.out.println(inventory.getallSwitches());
    	System.out.println("\n\n");
    	
    	System.out.println(ShoppingCart.getCartItems());
    	
    	if(!customerFirstName.getText().isBlank() && !customerLastName.getText().isBlank() && !customerEmail.getText().isBlank() && !customerPhoneNum.getText().isBlank() && !customerAddress.getText().isBlank()) {
    		if(validate.isValidCard(cardNumber.getText().toString(), cardCVC.getText().toString(), cardExpMonth.getText().toString(), cardExpYear.getText().toString())) {
//        		System.out.println("Card Number: " + cardNumber.getText().toString());
//        		System.out.println("Card CVC: " + cardCVC.getText().toString());
//        		System.out.println("Card Expiration Month: " + cardExpMonth.getText().toString());
//        		System.out.println("Card Expiration Year: " + cardExpYear.getText().toString());
        		customers.add(new customer(customerFirstName.getText().toString(), customerLastName.getText().toString(), customerEmail.getText().toString(), customerPhoneNum.getText().toString(), customerAddress.getText().toString(), update()));
        		//System.out.println("Shipping Method: " + shipping);
        		System.out.println("Payment process went through");
        		paymentProcessResult.setText("Payment has been processed");
        		createScene(event, "Orders.fxml");
        	} else {
        		paymentProcessResult.setText("Card information is invalid");
        		System.out.println("Invalid Card Information Entered");
        	}
    	} else {
    		paymentProcessResult.setText("Fill in all fields");
    		System.out.println("Info is blank");
    	}
    }
    
//    /**
//     * The initialize method runs as a method to load UI elements just as the program is starting
//     * @param URL program starting
//     * @param resourceBundle gathers the resources
//     */
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//    	
//    }
}
 