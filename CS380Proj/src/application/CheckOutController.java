package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;
import Company.customer;
import Company.inventory;
import Company.orders;
import Company.ShoppingCart;
import application.shoppingCartController.cartItem;

/**
CheckOutController
Date of code: 8/13/25
This controller class handles all of the UI elements of the CheckOut page
This includes things like verify if credit card is valid or getting the customer information
@author Nery Armaz
*/
public class CheckOutController extends SceneController/*implements Initializable*/{
    
    
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
     * An object of the CreditCardValidation class in order to use isValidCard method
     */
    private CreditCardValidation validate;
    
    /**
     * This list holds all of the customers that will make a purchase
     */
    private static List<customer> customers = new ArrayList<>();
    
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
     * @return customer add by 1
     */
    private int update() {
    	return ++customerCount;
    }
    
    public static List<customer> getAllCustomers() {
    	List<customer> allCustomer = customers;
    	return allCustomer;
    }
    
    
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
    	ArrayList<Integer> productId = new ArrayList<>();
    	ArrayList<String> productNames = new ArrayList<>();
    	ObservableList<cartItem> cart = FXCollections.observableArrayList();
    	for (var entry: ShoppingCart.getCartItems().entrySet()) {
    		cart.add(new cartItem(entry.getKey(), entry.getValue()));
    	}
    	
    	for(cartItem item: cart) {
    		productId.add(item.getProdID());
    		productNames.add(item.getName());
    	}
    	
    	if(!customerFirstName.getText().isBlank() && !customerLastName.getText().isBlank() && !customerEmail.getText().isBlank() && !customerPhoneNum.getText().isBlank() && !customerAddress.getText().isBlank()) {
    		if(validate.isValidCard(cardNumber.getText().toString(), cardCVC.getText().toString(),
    				cardExpMonth.getText().toString(), cardExpYear.getText().toString())) {
    			
    			//testing
//        		System.out.println("Card Number: " + cardNumber.getText().toString());
//        		System.out.println("Card CVC: " + cardCVC.getText().toString());
//        		System.out.println("Card Expiration Month: " + cardExpMonth.getText().toString());
//        		System.out.println("Card Expiration Year: " + cardExpYear.getText().toString());
    			
    			customer newCustomer = new customer(customerFirstName.getText().toString(), customerLastName.getText().toString(), customerEmail.getText().toString(), customerPhoneNum.getText().toString(), customerAddress.getText().toString(), update());
    			customers.add(newCustomer);
    			orders newOrder = new orders(
    					newCustomer.getID(),
    					orders.updateID(),
    					productId, ShoppingCart.getTotalPrice(),
    					shoppingCartController.getShippingMethod(),
    					productNames,
    					newCustomer.getFirstName(),
    					newCustomer.getEmail(),
    					newCustomer.getAddress());
        		//customers.add(new customer(customerFirstName.getText().toString(), customerLastName.getText().toString(), customerEmail.getText().toString(), customerPhoneNum.getText().toString(), customerAddress.getText().toString(), update()));
        		//System.out.println("Shipping Method: " + shipping);
        		System.out.println("Payment process went through");
        		paymentProcessResult.setText("Payment has been processed");
        		OrdersController.allOrders.add(newOrder);
        		ShoppingCart.clearCart();
        		createScene(event, "Orders.fxml");
        		//OrdersController.AppendRecentOrder();     		
        		// send email using the new order object
        		OrdersController.sendEmail(newOrder);
        		
        		
        	} else {
        		paymentProcessResult.setText("Card information is invalid");
        		System.out.println("Invalid Card Information Entered");
        	}
    	} else {
    		paymentProcessResult.setText("Fill in all fields");
    		System.out.println("Info is blank");
    	}
    }
}
 