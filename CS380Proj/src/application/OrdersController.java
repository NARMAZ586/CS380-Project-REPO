package application;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Company.orders;
import Company.products.product;
import Company.ShoppingCart;
import Company.customer;
import application.shoppingCartController.cartItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
OrdersController
Date of code: 8/15/25
This controller class handles all of the UI elements of the Orders page
This includes things like displaying the orders and putting it in a csv file
@author Nery A.
*/
public class OrdersController extends SceneController {
	/**
	 * Table view that displays cart item summary
	 */
	@FXML private TableView<cartItem> cartTableView;
	/**
	 * Column for displaying product names
	 */
	@FXML private TableColumn<cartItem, String> productName;
	/**
	 * Column for displaying unit prices of items
	 */
	@FXML private TableColumn<cartItem, String> unitPrice;
	/**
	 * Column for displaying quantity of each cart item
	 */
	@FXML private TableColumn<cartItem, String> QuantityItem;
	/**
	 * Column for displaying total price per line
	 */
	@FXML private TableColumn<cartItem, String> Price;
	/**
	 * Label for displaying the order ID
	 */
	@FXML private Label orderIDLabel;
	/**
	 * Label for displaying customers name
	 */
	@FXML private Label customerNameLabel;
	/**
	 * Label for displaying customers email
	 */
	@FXML private Label customerEmailLabel;
	/**
	 * Label for displaying customers phone number
	 */
	@FXML private Label customerPhoneLabel;
	/**
	 * Label for displaying shipping address
	 */
	@FXML private Label shippingLabel;
	/**
	 * Label for displaying selected shipping method
	 */
	@FXML private Label shipMethodLabel;
	/**
	 * Label for displaying selected payment
	 */
	@FXML private Label paymentLabel;
	/**
	 * Label for displaying subtotal amount
	 */
	@FXML private Label subtotalLabel;
	/**
	 * Label for displaying total cost including shipping
	 */
	@FXML private Label totalLabel;
	
	/**
	 * List of customers gathered from the checkout
	 */
	private static List<customer> customers = CheckOutController.getAllCustomers();
	/**
	 * List of orders placed
	 */
	public static List<orders> allOrders = new ArrayList<>();
	/**
	 * Internal customer used to track/assign the order IDs
	 */
	private int orderNum = 0;
	/**
	 * default constructor for OrdersController
	 */
	public OrdersController() {}
	/**
	 * method of creating the OrdersCSV, if it doesn't exist and it also reads any possible saved entries into allOrders list
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
                        for (String pid : pieces[2].trim().split(";")) {
                            productIds.add(Integer.parseInt(pid.trim()));
                        }
                        double price = Double.parseDouble(pieces[3].trim());
                        String shippingMethod = pieces[4].trim();
                        ArrayList<String> itemNames = new ArrayList<>();
                        for (String item : pieces[5].trim().split(";")) {
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
	/**
	* Appends the recent order details to Inventory.csv, what this includes is
	* the customer ID, order ID, product IDs, total price, shipping method, item names, and customer info.
	* The data is formatted with a new line in the csv file, this assumes that from the most recent order
	* would be towards the end from the allOrders list.
	*/
	public static void AppendRecentOrder(orders recentOrder) {
		File file = new File("Database/Orders.csv");
		try (FileWriter writer = new FileWriter(file, true);) {
			String productIDs = recentOrder.getProductID().stream().map(String::valueOf).collect(Collectors.joining(";"));
			String itemNames = recentOrder.getItem().stream().map(String::valueOf).collect(Collectors.joining(";"));
			writer.append(String.format("\n%d, %d, %s, %.2f, %s, %s, %s, %s, %s", recentOrder.getCustomerID(), recentOrder.getOrderID(), productIDs, recentOrder.gettotalPrice(), recentOrder.getShipMethod(), itemNames, recentOrder.getfirstname(), recentOrder.getEmail(), recentOrder.getaddress()));
			System.out.println("Appended new order");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
//	/**
//	 * Uses increments and returns a new order ID.
//	 * @return Next available orderID.
//	 */
//	private int updateID() {
//		return ++orderNum;
//	}
	
	/**
	 * Loads and displays most recent order with the customers data.
	 * It then gets the most recent order from the allOrders list.
	 * Then fetches the most recent customer from the customers list.
	 * It calculates the subtotal and the total quantity based off the current items in the shopping cart.
	 * Updates the label fields with the data retrieved.
	 * Populates the items and the quantity amount in the shopping cart as a table view.
	 */
	public void loadOrderData() {
		customer mostRecentCustomer = new customer();
		if(!customers.isEmpty()) {
			mostRecentCustomer = customers.get(customers.size() - 1);
		}
		orders recent = null;
		if (!allOrders.isEmpty()) {
		    int size = allOrders.size() - 1;
		    recent = allOrders.get(size);
		} else {
		    // handle empty case
		    System.out.println("No orders available.");
		    return; // or set labels to empty strings
		}
		String fullname = mostRecentCustomer.getFirstName() + " " + mostRecentCustomer.getLastName();
		String phone = mostRecentCustomer.getPhoneNumber();
		double subtotal = 0;
		int quantity = 0;
		int totalQuantity = 0;
		for(Map.Entry<product, Integer> entry: ShoppingCart.getCartItems().entrySet()) {
			product prod = entry.getKey();
			quantity = entry.getValue();
			totalQuantity += quantity;
			subtotal += prod.getPrice() * quantity;
		}
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
	/**
	 * This is the email that is sending the email confirmation(2 Factor)
	 */
	private static String username = "squadsoftware60@gmail.com";
	/**
	 * App password which grants program all privileges to the gmail account above
	 * It essentially allows the program to send an email from that account at any point
	 */
	private static String password = "otdj qrcv korx psan";
	
	/**
	 * Sends an order confirmation email to the customer.
	 * This sets the SMTP properties in using the Gmail's SMTP server,
	 * it then authenticates it using the specific email and password,
	 * it sets a confirmation email with the order details, and sends
	 * the details to the customers email address they provided.
	 * Also with this method you can send a email confirmation as long as it is a valid email
	 * @param newOrder The instance of the orders class that contains the customers email,
	 * order ID, shipping method selected, price total, and product items.
	 */
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
	    if (items.length() > 0) items.setLength(items.length() - 2);
		
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
	
	/**
	 * Initializes the table columns from the order confirmation view.
	 * The method sets up the cell value factories for each of the columns in the 
	 * table view for the properties of the shopping cart items such as
	 * product name, ID, quantity, and total price. It loads the most recent order
	 * information from the shopping cart and the customer details that populate the latest information.
	 */
	public void initialize() {
		productName.setCellValueFactory(new PropertyValueFactory<>("name"));
		unitPrice.setCellValueFactory(new PropertyValueFactory<>("prodID"));
		QuantityItem.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		Price.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
		
		loadOrderData();
    }
	
}