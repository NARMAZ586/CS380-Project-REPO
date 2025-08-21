package Company;
import java.util.ArrayList;

/** 
 * orders
 * 08/8/2025
 * 
 * Class Description:Class is to represent ordering system for the shop, containing info relevant to shop orders
 * 
 * Important Functions:
 * Getter and setter functions for Order attributes
 * 
 * DataStructures:
 * ArrayList product: used to hold product objects
 * GridPane: Layout to display product cars in a grid
 * @author Matthew Berleson
 */

public class orders {
	
	/**
	* customer Id of class orders 
	*/	
	private int customerID;
	/**
	* order Id of class orders 
	*/
	private int orderID;
	
	//private static int lastOrderid = 0;
	/**
	* product Id of class orders 
	*/
	private ArrayList<Integer> productID;
	/**
	* total price of class orders 
	*/
	private double totalPrice;
	/**
	* shipping method of class orders 
	*/
	private String shippingMethod;
	/**
	* payment Method of class orders 
	*/
	private String paymentMethod = "Card";
	/**
	* item name of the order
	*/
	private ArrayList<String> itemNames;
	/**
	 * The customer's first name.
	 */
	private String firstName;

	/**
	 * The customer's email address.
	 */
	private String email;

	/**
	 * The customer's mailing address.
	 */
	private String address;
	
	
	/**
	 * constructor for the orders class
	 * @param customerID ID of customer placing order
	 * @param orderID ID of placed order
	 * @param productID ID of product ordered
	 * @param price price of products
	 * @param shippingMethod shipping date for order
	 * @param itemName name of the item ordered
	 * @param name name of the customer
	 * @param email email of the customer
	 * @param address address of the customer
	 */
	public orders(int customerID, int orderID, ArrayList<Integer> productID, double price, String shippingMethod, ArrayList<String> itemName, String name, String email, String address) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.productID = productID;
        this.totalPrice = price;
        this.shippingMethod = shippingMethod;
        this.itemNames = itemName;
        this.firstName = name;
        this.email = email;
        this.address = address;
    }
	
	
//	// PLEASE REMOVE THIS  LATER ON
//	/**
//	 * Increments and returns the next order ID.
//	 * @return next order ID
//	 */
//	public int updateID () {
//		return ++orderID;
//	}
	
	/**
	 * Returns the shipping method.
	 * @return shipping method
	 */
	public String getShipMethod() {
		return shippingMethod;
	}
	/**
	 * Returns the customer's first name.
	 * @return first name
	 */
	public String getfirstname() {
		return firstName;
	}
	/**
	 * Returns the customer's email.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Returns the customer's address.
	 * @return address
	 */
	public String getaddress () {
		return address;
	}

	/**
	 *gets customerID
	 *@return customerID 
	 */
	public int getCustomerID() {
		return customerID;
		
	}
	
	/**
	 *gets orderID
	 *@return orderID
	 */
	public int getOrderID() {
		return orderID;
		
	}
	
	/**
	 *gets productID
	 *@return productID
	 */
	public ArrayList<Integer> getProductID() {
		return productID;
		
	}
	
	/**
	 *gets price
	 *@return price
	 */
	public double gettotalPrice() {
		return totalPrice;
		
	}
	
	/**
	 *gets shipping Date
	 *@return shippingDate
	 */
	public String getDate() {
		return shippingMethod;
		
	}
	
	/**
	 *gets payment Method
	 *@return paymentMethod
	 */
    public String getPayment() {
		return paymentMethod;
		
	}
    
	/**
	 *gets customerID
	 *@return customerID
	 */
    public ArrayList<String> getItem() {
		return itemNames;
		
	}
    
    /**
     * Sets the customer's first name.
     * @param name the first name to set
     */
    public void setfirstname(String name) {
    	this.firstName = name;
    }
    /**
     * Sets the customer's email.
     * @param email the email to set
     */
    public void setEmail(String email) {
    	this.email = email;
    }
    /**
     * Sets the customer's address.
     * @param address the address to set
     */
    public void setAddress(String address) {
    	this.address = address;
    }

	/**
	 *Sets customerID
	 *@param customerID The customer ID of the order
	 */
    public void setCustomerID(int customerID) {
    	this.customerID = customerID;
    }
    
	/**
     * Sets the order ID.
     * @param orderID The ID of the order.
     */
    public void setOrderID(int orderID) {
    	this.orderID = orderID;
    }

	/**
     * Sets the product ID.
     * @param productID The ID of the product.
     */
    public void setProductID(ArrayList<Integer> productID) {
	    this.productID = productID;
    }

	/**
     * Sets the price.
     * @param price The price of the product.
     */
    public void setPrice(double price) {
	    this.totalPrice = price;
    }

	/**
     * Sets the shipping date.
     * @param shippingDate The shipping date of the order.
     */
    public void setDate(String shippingDate) {
	    this.shippingMethod = shippingDate;
    }

	/**
     * Sets the payment Method.
     * @param paymentMethod The paymentMethod of the order.
     */
    public void setPayment(String paymentMethod) {
	    this.paymentMethod = paymentMethod;
    }
    
	/**
     * Sets the item Name.
     * @param itemName The itemName of the product.
     */
    public void setItem(ArrayList<String> itemName) {
    	this.itemNames = itemName;
    }
}
