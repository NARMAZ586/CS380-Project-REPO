package application;
import Company.ShoppingCart;
import Company.products.product;
import Company.inventory;
import java.util.ArrayList;
import java.util.List;
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

public class shoppingCartController extends SceneController{
	@FXML private TableView<cartItem> cartTableView;
	
	@FXML private Label subtotalLabel;
	
	@FXML private Label totalLabel;
	
	@FXML private TableColumn<cartItem, String> productName;
	
	@FXML private TableColumn<cartItem, String> unitPrice;
	
	@FXML private TableColumn<cartItem, String> QuantityItem;
	
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
    
    @FXML private Label shippingLabel;
    
    @FXML private Label quantityLabel;
    
    private static String shippingMethod;
	
	
	public static class cartItem{
		private product prod;
		private int quantity;
		
		public cartItem(product product, int quantity) {
			this.prod = product;
			this.quantity = quantity;
		}
		
		public String getName() {
			return prod.getName();
		}
		
		public int getQuantity() {
			return quantity;
		}
		
		public String getPricePerItem() {
			return "$" + String.format("%.2f", prod.getPrice());
		}
		
		public String getTotalPrice() {
			return "$" + String.format("%.2f", prod.getPrice() * quantity);
		}
		
		public double getTotalPriceNum() {
			return prod.getPrice() * quantity;
		}
		
	}
	
	public static String getShippingMethod() {
		return shippingMethod;
	}
	
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
	
	private double shippingCost() {
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
	
	public void initialize() {
		productName.setCellValueFactory(new PropertyValueFactory<>("name"));
		unitPrice.setCellValueFactory(new PropertyValueFactory<>("pricePerItem"));
		QuantityItem.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		Price.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
		
		loadCart();
		
		shippingOptions.selectedToggleProperty().addListener((obs, oldToggle, newTogle) -> {
			updateTotals();
		});
	}
}
