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
public class CheckOutController extends SceneController{ 
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
    public static List<customer> customers = new ArrayList<>();
    
    /**
     * Integer for the customer ID
     */
    private int customerCount = 0;
    private int orderID = 0;
    
    /**
     * Constructor for the CheckOutController class
     */
    public CheckOutController() {}
    private int updateOrderID() {
    	if (!OrdersController.allOrders.isEmpty()) {
    		int index = OrdersController.allOrders.size() - 1;
    		orderID = OrdersController.allOrders.get(index).getOrderID();
    		return ++orderID; 
    	} else {
    		return ++orderID;
    	}
    }
    
    /**
     * Method that updates the customer ID
     * @return customer add by 1
     */
    private int update() {
    	if (!customers.isEmpty()) {
    		int index = customers.size() - 1;
    		customerCount = customers.get(index).getID();
    		return ++customerCount;
    	} else {
    		return ++customerCount;
    	}
    }
    /**
     * Retrieves a list of all customers currently stored in the system
     * @return List containing all Customer objects in the system
     */
    public static List<customer> getAllCustomers() {
    	List<customer> allCustomer = customers;
    	return allCustomer;
    }
   
    /**
     * Method receives the parameters for the constructor of a customer and it creates and adds a new customer to list
     * @param fName parameter for firstname
     * @param lName parameter for lastname
     * @param email parameter for email
     * @param phone parameter for phone number
     * @param address parameter for street address
     * @param id parameter for the customer ID
     */
   public static void addCustomer(String fName, String lName, String email, String phone, String address, int id) {
	   customers.add(new customer(fName, lName, email, phone, address, id));
   }
   
   /**
    * Method finds and returns the customer list size
    * @return size of the customers list
    */
   public static int customersSize() {
	   return customers.size();
   }
    
    /**
     * Triggered when btnPayNow is clicked, it verified if all fields on this page are valid
     * Credit card must be valid(Online fake card generator can be used to get a card number)
     * CVC is any string of length 3 or 4 all comprised of digits
     * Expiration month is valid for 1 - 12
     * Expiration year is valid for 2025 - 2030
     * @param event Waits and expects a button click on btnPayNow
     */
    public void VerifyPaymentProcess(ActionEvent event) {
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
    			customer newCustomer = new customer(customerFirstName.getText().toString(), customerLastName.getText().toString(), customerEmail.getText().toString(), customerPhoneNum.getText().toString(), customerAddress.getText().toString(), update());
    			customers.add(newCustomer);
    			orders newOrder = new orders(newCustomer.getID(), updateOrderID(), productId, ShoppingCart.getTotalPrice(), shoppingCartController.getShippingMethod(), productNames, newCustomer.getFirstName(), newCustomer.getEmail(), newCustomer.getAddress());
    			customer.writeSinglecustomer(newCustomer);
        		System.out.println("Payment process went through");
        		paymentProcessResult.setText("Payment has been processed");
        		OrdersController.allOrders.add(newOrder);
        		OrdersController.AppendRecentOrder(newOrder);
        		ShoppingCart.clearCart();
        		createScene(event, "Orders.fxml");
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
 