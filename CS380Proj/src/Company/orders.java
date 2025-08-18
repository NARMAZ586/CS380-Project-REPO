package Company;
import java.util.ArrayList;
import Company.products.product;

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
	int customerID;
	/**
	* order Id of class orders 
	*/
	int orderID = 0;
	/**
	* product Id of class orders 
	*/
	int productID;
	/**
	* total price of class orders 
	*/
	double totalPrice;
	/**
	* shipping method of class orders 
	*/
	String shippingMethod;
	/**
	* payment Method of class orders 
	*/
	String paymentMethod = "Card";
	/**
	* item name of the order
	*/
	ArrayList<product> itemNames;
	
	String firstName;
	
	String email;
	
	String address;
	
	
	//constructor 
	/**
	 *constructor for the orders class
	 *
	 *@param customerID ID of customer placing order
	 *@param orderID ID of placed order
	 *@param productID ID of product ordered
	 *@param price price of products
	 *@param shippingDate shipping date for order
	 *@param paymentMethod method used for payment
	 *@param itemName name of the item ordered
	 */
	public orders(int customerID, int orderID, int productID, double price, String shippingMethod, ArrayList<product> itemName, String name, String email, String address) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.productID = productID;
        this.totalPrice = price;
        this.shippingMethod = shippingMethod;
        //this.paymentMethod = paymentMethod;
        this.itemNames = itemName;
        this.firstName = name;
        this.email = email;
        this.address = address;
    }
	
	public int updateID () {
		return ++orderID;
	}
	
	// getter methods for order and product attributes
	
	public String getfirstname() {
		return firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String address () {
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
	public int getProductID() {
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
    public ArrayList<product> getItem() {
		return itemNames;
		
	}
    
    //Setter methods for order
    
    public void setfirstname(String name) {
    	this.firstName = name;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
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
    public void setProductID(int productID) {
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
    public void setItem(ArrayList<product> itemName) {
    	this.itemNames = itemName;
    }
    
    //FIX: NEED TO MAKE METHODS FOR CSV FILES AND DATA PALACEMENT - Matt
    
    
	
}
