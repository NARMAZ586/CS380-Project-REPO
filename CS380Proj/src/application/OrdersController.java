package application;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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

/**
OrdersController
Date of code: 8/15/25
This controller class handles all of the UI elements of the Orders page
This includes things like displaying the orders and putting it in a csv file
@author Nery A.
*/
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
	public static List<orders> allOrders = new ArrayList<>();
	
	private int orderNum = 0;


	/**
	 * default constructor for OrdersController
	 */
	public OrdersController() {}
	/**
	 * method of the write default orders
	 */
	public static void createOrdersCSV() {
		File file = new File("Database/Orders.csv");
		file.getParentFile().mkdirs();
		boolean fileExists = file.exists();
		
		try {
			if(!fileExists) {
				FileWriter writer = new FileWriter(file, true);
				writer.append("Customer ID, Order ID, Product ID, Price, Shipping Method, Item Name, First Name, Email, Street Address");
				writer.close();
				System.out.println("Created orders.csv");
			}
			
			if(file.exists()) {
				try(BufferedReader br = new BufferedReader(new FileReader(file))) {
					String line;
					boolean first = true;
					while((line = br.readLine()) != null) {
						if(first) {
							first = false;
							continue;
						}
						String [] pieces = line.split(",");
						int customerId;
						int orderId;
						if(pieces.length >= 9) {
							customerId = Integer.parseInt(pieces[0].trim());
	                        orderId = Integer.parseInt(pieces[1].trim());
					
						ArrayList<Integer> productIds = new ArrayList<>();
                        for (String pid : pieces[2].trim().split("\\|")) {
                            productIds.add(Integer.parseInt(pid.trim()));
                        }
                        double price = Double.parseDouble(pieces[3].trim());
                        String shippingMethod = pieces[4].trim();
                        ArrayList<String> itemNames = new ArrayList<>();
                        for (String item : pieces[5].trim().split("\\|")) {
                            itemNames.add(item.trim());
                        }
                        String firstName = pieces[6].trim();
                        
                        String email = pieces[7].trim();
                        String streetAddress = pieces[8].trim();
                        orders order = new orders(customerId, orderId, productIds, price, shippingMethod, itemNames, firstName, email, streetAddress);
                        allOrders.add(order);
					}
				}
			}
		}
	} catch (IOException e) {
		e.printStackTrace();
	}	
}
	
	
	public static void AppendRecentOrder(orders recentOrder) {
		File file = new File("Database/Orders.csv");
		try (FileWriter writer = new FileWriter(file, true);) {
			//int size = allOrders.size() - 1;
			//orders recent = allOrders.get(size);
			String productIDs = recentOrder.getProductID().stream().map(String::valueOf).collect(Collectors.joining(";"));
			String itemNames = recentOrder.getItem().stream().map(String::valueOf).collect(Collectors.joining(";"));
			writer.append(String.format("\n%d, %d, %s, %.2f, %s, %s, %s, %s, %s", recentOrder.getCustomerID(), recentOrder.getOrderID(), productIDs, recentOrder.gettotalPrice(), recentOrder.getShipMethod(), itemNames, recentOrder.getfirstname(), recentOrder.getEmail(), recentOrder.getaddress()));
			System.out.println("Appended new order");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	private int updateID() {
//		if (!allOrders.isEmpty()) {
//    		int index = allOrders.size() - 1;
//    		orderNum = allOrders.get(index).getOrderID();
//    		return ++orderNum;
//    	} else {
//    		return ++orderNum;
//    	}
//	}
	public void loadOrderData() {
		customer mostRecentCustomer = new customer();
		if(!customers.isEmpty()) {
			mostRecentCustomer = customers.get(customers.size() - 1);
		}
//		int size = 0;
//		if (allOrders.size() > 0) {
//			size = allOrders.size() - 1;
//		}else {
//			size = 0;
//		}
		
		//orders recent = allOrders.get(size);
		orders recent = null;
		if (!allOrders.isEmpty()) {
		    int size = allOrders.size() - 1; // safe because list not empty
		    recent = allOrders.get(size);
		} else {
		    // handle empty case
		    System.out.println("No orders available.");
		    return; // or set labels to empty strings
		}
		String fullname = mostRecentCustomer.getFirstName() + " " + mostRecentCustomer.getLastName();
		//String email = mostRecentCustomer.getEmail();
		String phone = mostRecentCustomer.getPhoneNumber();
		//int customerId = mostRecentCustomer.getID();
		//String address = mostRecentCustomer.getAddress();
		//int orderID = updateID();
		
		double subtotal = 0;
		//double total = 0;
		int quantity = 0;
		int totalQuantity = 0;
		for(Map.Entry<product, Integer> entry: ShoppingCart.getCartItems().entrySet()) {
			product prod = entry.getKey();
			quantity = entry.getValue();
			totalQuantity += quantity;
			subtotal += prod.getPrice() * quantity;
		}
//		String shipping = shoppingCartController.getShippingMethod();
//		double shippingCost = 0.0;
//		switch(shipping) {
//		case "14 Day Free Shipping":
//			shippingCost = 0.0;
//			break;
//		case "4 - 6 Day Shipping":
//			shippingCost = 5.50;
//			break;
//		case "1 - 3 Day Shipping":
//			shippingCost = 11.50;
//			break;
//		}
		//total = shippingCost + subtotal;
		orderIDLabel.setText(String.valueOf(recent.getOrderID()));
		customerNameLabel.setText(fullname);
		customerEmailLabel.setText(recent.getEmail());
		customerPhoneLabel.setText(phone);
		shippingLabel.setText(recent.getaddress());
		shipMethodLabel.setText(recent.getShipMethod());
		paymentLabel.setText(recent.getPayment());
		subtotalLabel.setText(String.valueOf(subtotal));
		totalLabel.setText(String.valueOf(recent.gettotalPrice()));
		
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
	
	public static void sendEmail(orders newOrder) {
	    String customerEmail = newOrder.getEmail();
	    String orderId = String.valueOf(newOrder.getOrderID());
	    String shipMethod = newOrder.getDate(); // shipping method
	    double total = newOrder.gettotalPrice();
	    ArrayList<String> itemNames = newOrder.getItem();
	    
	    StringBuilder items = new StringBuilder();
	    for (String item : itemNames) {
	        items.append(item).append(", ");
	    }
	    if (items.length() > 0) items.setLength(items.length() - 2); // remove trailing comma
		
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
			email.setSubject("Order Confirmation - #" + orderId);
			String message = "Hello" + newOrder.getfirstname() + "\n\n" +
                    "Thank you for your order!\n" +
                    "Order ID: " + orderId + "\n" +
                    "Item: " + items + "\n" +
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
