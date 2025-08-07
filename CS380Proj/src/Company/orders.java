package Company;

public class orders {
	
	
	int customerID;
	int orderID;
	int productID;
	double price;
	String shippingDate;
	String paymentMethod;
	String itemName;
	
	
	//constructor 
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
	public int getCustomerID() {
		return customerID;
		
	}
	
	public int getOrderID() {
		return orderID;
		
	}
	
	public int getProductID() {
		return productID;
		
	}
	
	public double getPrice() {
		return price;
		
	}
	
	public String getDate() {
		return shippingDate;
		
	}
	
    public String getPayment() {
		return paymentMethod;
		
	}
    
    public String getItem() {
		return itemName;
		
	}
    
    //Setter methods for order
    public void setCustomerID(int customerID) {
    	this.customerID = customerID;
    }
    
    public void setOrderID(int orderID) {
    	this.orderID = orderID;
    }

    public void setProductID(int productID) {
	    this.productID = productID;
    }

    public void setPrice(double price) {
	    this.price = price;
    }

    public void setDate(String shippingDate) {
	    this.shippingDate = shippingDate;
    }

    public void setPayment(String paymentMethod) {
	    this.paymentMethod = paymentMethod;
    }
    
    public void setItem(String itemName) {
    	this.itemName = itemName;
    }
    
    //FIX: NEED TO MAKE METHODS FOR CSV FILES AND DATA PALACEMENT - Matt
    
    
	
}
