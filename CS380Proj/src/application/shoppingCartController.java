package application;
import Company.ShoppingCart;
import Company.products.product;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableColumn;
/**
shoppingCartController
Date of code: 8/16/25
This controller class handles all of the UI elements of the Shopping Cart page
This includes things like displaying the selected products, checks out option, and displays the price depending on quantity
@author Nery A.
*/
public class shoppingCartController extends SceneController{
	/**
	 * default constructor of shoppingCartController
	 */
	public shoppingCartController() {};
	/**
	 * Table view of the cart item
	 */
	@FXML private TableView<cartItem> cartTableView;
	/**
	 * displays of the subtotal of the shopping cart
	 */
	@FXML private Label subtotalLabel;
	/**
	 * displays the total of the shopping cart
	 */
	@FXML private Label totalLabel;
	/**
	 * displays the product name in a string in a table column 
	 */
	@FXML private TableColumn<cartItem, String> productName;
	/**
	 * displays the product unit price in a string in a table column 
	 */	
	@FXML private TableColumn<cartItem, String> unitPrice;
	/**
	 * displays the product quantity in a string in a table column 
	 */
	@FXML private TableColumn<cartItem, String> QuantityItem;
	/**
	 * displays the product price in a string in a table column 
	 */
	@FXML private TableColumn<cartItem, String> Price;
	
	/**
     * The free shipping method available to user
     */
    @FXML private RadioButton optionFree;
	
	/**
     * The standard shipping method available to user
     */
    @FXML private RadioButton optionStandard;
    
    /**
     * The express shipping method available to user
     */
    @FXML private RadioButton optionExpress;
    
    /**
     * The group name for the radio buttons
     */
    @FXML private ToggleGroup shippingOptions;
    /**
     * displays the shipping label
     */
    @FXML private Label shippingLabel;
    /**
     * displays the quantity label
     */
    @FXML private Label quantityLabel;
    /**
     * have a string of the shipping method
     */
    private static String shippingMethod;
	
    /** 
     *  class for the cart item
     */
	public static class cartItem{
		/**
		 * have the product in shopping cart
		 */
		private product prod;
		/**
		 * have the number of quantity in shopping cart
		 */
		private int quantity;
		/**
		 * displays the product and quantity of the item in cart
		 * @param product constructor of product
		 * @param quantity constructor of quantity
		 */
		public cartItem(product product, int quantity) {
			this.prod = product;
			this.quantity = quantity;
		}
		/**
		 * gets the Name
		 * @return returns the name product in Shopping cart
		 */
		public String getName() {
			return prod.getName();
		}
		/**
		 * gets the quantity
		 * @return returns the quantity in the shopping cart
		 */
		public int getQuantity() {
			return quantity;
		}
		/**
		 * displays the price per item
		 * @return returns the price per item in a string
		 */
		public String getPricePerItem() {
			return "$" + String.format("%.2f", prod.getPrice());
		}
		/**
		 * displays the total price
		 * @return returns the total price of the products
		 */
		public String getTotalPrice() {
			return "$" + String.format("%.2f", prod.getPrice() * quantity);
		}
		/**
		 *  function of calculating the price through quantity
		 * @return returns the total amount of price depending on quantity
		 */
		public double getTotalPriceNum() {
			return prod.getPrice() * quantity;
		}
		/**
		 *gets prodID
		 *@return product ID
		 */	
		public int getProdID() {
			return prod.getprodID();
		}
		
	}
	/**
	 * gets the shipping method as a string
	 * @return returns the shipping method
	 */
	public static String getShippingMethod() {
		return shippingMethod;
	}
	/**
	 * gets the shipping through string and radio button
	 * @return string returns to the shippingMethod
	 */
	private String getShipping() {
    	String shippingMethod;
    	RadioButton picked = (RadioButton) shippingOptions.getSelectedToggle();
    	if (picked != null) {
    		shippingMethod = picked.getText();
    	} else {
    		shippingMethod = null;
    	}
    	return shippingMethod;
    }
	
	/**
	 * displays the shipping cost
	 * @return returns depending which case has chosen
	 */
	
	public double shippingCost() {
		String shipping = getShipping();
		if (shipping == null) {
			return 0.0;
		}
		shippingMethod = shipping;
		
		switch(shipping) {
		case "14 Day Free Shipping":
			return 0.0;
		case "4 - 6 Day Shipping":
			return 5.50;
		case "1 - 3 Day Shipping":
			return 11.50;
		default:
			return 0;
		}
	}
	/**
	 * updates the totals of the shopping cart
	 */
	private void updateTotals() {
		double subtotal = 0.0;
		for (cartItem item : cartTableView.getItems()) {
		    subtotal += item.getTotalPriceNum();
		}

		double shipping = shippingCost();
		double total = subtotal + shipping;

		// Update labels
		shippingLabel.setText("$" + String.format("%.2f", shipping));
		subtotalLabel.setText("$" + String.format("%.2f", subtotal));
		totalLabel.setText("$" + String.format("%.2f", total));
	}
	/**
	 * loads the cart of the shopping cart
	 */
	private void loadCart() {
		//List<product> allProds = inventory.getAllProducts();
		ObservableList<cartItem> cartData = FXCollections.observableArrayList();
		for(var entry: ShoppingCart.getCartItems().entrySet()) {
			cartData.add(new cartItem(entry.getKey(), entry.getValue()));
		}
		cartTableView.setItems(cartData);
		
		double subtotal = 0;
		double total = 0;
		int quantity = 0;
		int totalQuantity = 0;
		for(Map.Entry<product, Integer> entry: ShoppingCart.getCartItems().entrySet()) {
			product prod = entry.getKey();
			quantity = entry.getValue();
			totalQuantity += quantity;
			subtotal += prod.getPrice() * quantity;
		}
		
		total = shippingCost() + subtotal;
		
		quantityLabel.setText(String.valueOf(totalQuantity));
		subtotalLabel.setText("$" + String.format("%.2f", subtotal));
		totalLabel.setText("$" + String.format("%.2f", total));
	}
	/**
	 * initializes the shopping cart
	 */
	public void initialize() {
		productName.setCellValueFactory(new PropertyValueFactory<>("name"));
		unitPrice.setCellValueFactory(new PropertyValueFactory<>("pricePerItem"));
		QuantityItem.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		Price.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
		
		shippingOptions.selectToggle(null);
		shippingMethod = null;
		
		loadCart();
		
		shippingOptions.selectedToggleProperty().addListener((obs, oldToggle, newTogle) -> {
			updateTotals();
		});
	}
	
	/**
     * restores stock, reloads table, and clears shipping when clear cart is pressed
     */
	@FXML
	private void clearCart() {
	    ShoppingCart.clearCartAndRestock(); // restore stock
	    loadCart();                         // reload table and totals
	    resetShipping();                    // clear shipping selection
	}
	
	/**
	 * Resets the shipping option.
	 * Clears the current selection from the toggle group and sets the shipping method to null.
	 */
	public void resetShipping() {
		shippingOptions.selectToggle(null);
	    shippingMethod = null;
	}
}
