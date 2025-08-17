package application;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import Company.orders;
import Company.products.product;
import Company.ShoppingCart;
import Company.customer;
import application.CheckOutController;
import application.shoppingCartController.cartItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleIntegerProperty;


public class OrdersController extends SceneController {
	@FXML private TableView<cartItem> cartTableView;
	@FXML private TableColumn<cartItem, String> productName;
	
	@FXML private TableColumn<cartItem, String> unitPrice;
	
	@FXML private TableColumn<cartItem, String> QuantityItem;
	
	@FXML private TableColumn<cartItem, String> Price;
	@FXML private Label orderIDLabel;
	@FXML private Label customerNameLabel;
	@FXML private Label customerEmailLabel;
	@FXML private Label customerPhoneLabel;
	@FXML private Label shippingLabel;
	@FXML private Label shipMethodLabel;
	@FXML private Label paymentLabel;
	@FXML private Label subtotalLabel;
	@FXML private Label totalLabel;
	private static List<customer> customers = CheckOutController.getAllCustomers();
	private int orderNum = 0;
	public static void writeDefaultOrders() {
		File file = new File("Database/Orders.csv");
		file.getParentFile().mkdirs();
		
	}
	
	private int updateID() {
		return ++orderNum;
	}
	public void loadOrderData() {
		customer mostRecentCustomer = new customer();
		if(!customers.isEmpty()) {
			mostRecentCustomer = customers.get(customers.size() - 1);
		}
		//String firstName = mostRecentCustomer.getFirstName();
		//String lastName = mostRecentCustomer.getLastName();
		//String fullName = firstName + " " + lastName;
		String fullname = mostRecentCustomer.getFirstName() + " " + mostRecentCustomer.getLastName();
		String email = mostRecentCustomer.getEmail();
		String phone = mostRecentCustomer.getPhoneNumber();
		int customerId = mostRecentCustomer.getID();
		String address = mostRecentCustomer.getAddress();
		int orderID = updateID();
		
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
		String shipping = shoppingCartController.getShippingMethod();
		double shippingCost = 0.0;
		switch(shipping) {
		case "14 Day Free Shipping":
			shippingCost = 0.0;
			break;
		case "4 - 6 Day Shipping":
			shippingCost = 5.50;
			break;
		case "1 - 3 Day Shipping":
			shippingCost = 11.50;
			break;
		}
		total = shippingCost + subtotal;
		orderIDLabel.setText(String.valueOf(updateID()));
		customerNameLabel.setText(fullname);
		customerEmailLabel.setText(email);
		customerPhoneLabel.setText(phone);
		shippingLabel.setText(address);
		shipMethodLabel.setText(shoppingCartController.getShippingMethod());
		paymentLabel.setText("Card");
		subtotalLabel.setText(String.valueOf(subtotal));
		totalLabel.setText(String.valueOf(total));
		
		ObservableList<cartItem> cartData = FXCollections.observableArrayList();
		for(var entry: ShoppingCart.getCartItems().entrySet()) {
			cartData.add(new cartItem(entry.getKey(), entry.getValue()));
		}
		cartTableView.setItems(cartData);
		
		
		
	}
	
//	public static void writeDefaultInventory() {
//		File file = new File("Database/Inventory.csv");
//		file.getParentFile().mkdirs();
//		List<product> keyboards = getAllKeyboards();
//		List<product> keycaps = getallKeycaps();
//		List<product> switches = getallSwitches();
//		try {
//			FileWriter writer = new FileWriter(file);
//			writer.append("Name, ID, Price, Type, Quantity, Description\n");
//			for (product k : keyboards) {
//				writer.append(String.format("%s,%d,%.2f,%s,%d,%s\n", k.getName(), k.getprodID(), k.getPrice(), k.prodType(), k.getStockQuantity(),k.prodDescription()));
//			}
//			for (product kc : keycaps) {
//				writer.append(String.format("%s,%d,%.2f,%s,%d,%s\n", kc.getName(), kc.getprodID(), kc.getPrice(), kc.prodType(), kc.getStockQuantity(),kc.prodDescription()));
//			}
//			for (product s : switches) {
//				writer.append(String.format("%s,%d,%.2f,%s,%d,%s\n", s.getName(), s.getprodID(), s.getPrice(), s.prodType(), s.getStockQuantity(),s.prodDescription()));
//			}
//			System.out.println("Successful write: Inventory.csv");
//			writer.close();
//		} catch(IOException e) {
//			System.out.println("Error occured while writing Inventory.csv");
//			e.printStackTrace();
//		}
//	}
	private static String username = "squadsoftware60@gmail.com";
	private static String password = "otdj qrcv korx psan";
	
	public static void sendEmail(String customerEmail, String OrderId, String shipMethod, double total, String itemName) {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true"); 
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message email = new MimeMessage(session);
			email.setFrom(new InternetAddress(username));
			email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerEmail));
			email.setSubject("Order Confirmation - #" + OrderId);
			String message = "Hello,\n\n" +
                    "Thank you for your order!\n" +
                    "Order ID: " + OrderId + "\n" +
                    "Item: " + itemName + "\n" +
                    "Shipping Method: " + shipMethod + "\n" +
                    "Total Cost: $" + total + "\n\n" +
                    "Best regards,\nYour Company Name";
			
			email.setText(message);
			Transport.send(email);
			System.out.println("Email was sent successfully");

		} catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void initialize() {
		productName.setCellValueFactory(new PropertyValueFactory<>("name"));
		unitPrice.setCellValueFactory(new PropertyValueFactory<>("prodID"));
		QuantityItem.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		Price.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
		
		loadOrderData();
    }
	
	
	
	
}
