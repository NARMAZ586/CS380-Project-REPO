package Company;

/** 
 * orders
 * 08/8/2025
 * @author Matthew Berleson
 * 
 * Class Description:Class is to represent ordering system for the shop, containing info relevant to shop orders
 * 
 * Important Functions:
 * Getter and setter functions for Order attributes
 * 
 * DataStructures:
 * ArrayList<product>: used to hold product objects
 * GridPane: Layout to display product cars in a grid
 */

public class orders {
	
	/**
	* customer Id of class orders 
	*/	
	int customerID;
	/**
	* order Id of class orders 
	*/
	int orderID;
	/**
	* product Id of class orders 
	*/
	int productID;
	/**
	* price of class orders 
	*/
	double price;
	/**
	* shipping date of class orders 
	*/
	String shippingDate;
	/**
	* payment Method of class orders 
	*/
	String paymentMethod;
	/**
	* item name of the order
	*/
	String itemName;
	
	
	//constructor 
	/**
	 *constructor for the orders class
	 *
	 *@param customerID ID of customer placing order
	 *@param orderID ID of placed order
	 *@param productID ID of product ordered
	 *@param price price of products
	 *@param ShippingDate shipping date for order
	 *@param paymentMethhod method used for payment
	 *@param itemName name of the item ordered
	 */
	public orders(int customerID, int orderID, int productID, double price, String shippingDate, String paymentMethod, String itemName) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.productID = productID;
        this.price = price;
        this.shippingDate = shippingDate;
        this.paymentMethod = paymentMethod;
        this.itemName = itemName;
    }
	
	// getter methods for order and product attributes

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
	public double getPrice() {
		return price;
		
	}
	
	/**
	 *gets shipping Date
	 *@return shippingDate
	 */
	public String getDate() {
		return shippingDate;
		
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
    public String getItem() {
		return itemName;
		
	}
    
    //Setter methods for order

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
	    this.price = price;
    }

	/**
     * Sets the shipping date.
     * @param shippingDate The shipping date of the order.
     */
    public void setDate(String shippingDate) {
	    this.shippingDate = shippingDate;
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
    public void setItem(String itemName) {
    	this.itemName = itemName;
    }
    
    //FIX: NEED TO MAKE METHODS FOR CSV FILES AND DATA PALACEMENT - Matt
    
    
	
}
