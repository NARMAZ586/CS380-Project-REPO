package application;
/**
    Controller
    Date of code: 8/4/25
    The controller class handles the navigation, interations, and logistics for the JavaFX application
    This is connected to multiple FXML files such as the Homepage, AdminPage, KeyboardPage, etc. this acts as the main handler for the user interface.
    @author Michelle
*/

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Company.products.product;
import Company.products;
import Company.customer;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller /*implements Initializable*/{
    /**
        Button to navigate to the keyboards page
    */
    @FXML private Button btnKeyboards;
    /**
        Button to navigate to the keycaps page
    */
    @FXML private Button btnKeycaps;
    /**
        Button to navigate to the switches page
    */
    @FXML private Button btnSwitches;
    /**
        Button to navigate to the shopping cart page
    */
    @FXML private Button btnCart;
    /**
        Button to navigate to the account user page
    */
    @FXML private Button btnAccount;

    /**
        Button to navigate to the keycaps page
    */
    @FXML private Button btnKeyCaps;
    /**
        A text field where the user inputs a product search
    */
    @FXML private TextField searchField;
    /**
        Container that displays live search results
    */
    @FXML private VBox searchResultsBox;
    /**
        Returns user to the homepage
    */
    @FXML private Button logoBtn;
    /**
        Entering the login email
    */
    @FXML private TextField loginEmail;
    /**
        Entering the ogin password
    */
    @FXML private PasswordField loginPassword;
    /**
        A label to display a login error message
    */
    @FXML private Label wrongPasswordLabel;
    /**
        Button used to logout the user and return to the homepage
    */
    @FXML private Button logoutBtn;
    
    //fx:id for switchpage
    /**
        Displays the selected products price
    */
    @FXML private Label priceLabel;
    /**
        Displays the selected products image
    */
    @FXML private ImageView productImg;
    /**
        Displays the selected products name
    */
    @FXML private Label productLabel; 
    /**
        Displays a selected switch image
    */
    @FXML private ImageView switchImg;
    /**
        Displays the selected switch name
    */
    @FXML private Label switchNameLabel;  
    /**
        Displays the selected switch's price
    */
    @FXML private Label switchPriceLabel;
    /**
        Styles the selected product card
    */
    @FXML private VBox chosenProductCard;
    /**
        Places all the product cards in a layout
    */
    @FXML private GridPane grid;
    /**
        Wraps the product grip used for scrolling
    */
    @FXML private ScrollPane scroll;
    /**
        Displays the product or image
    */
    @FXML private ImageView imageView;
    
    
    
    
    //stage and scene references
    /**
        Managing the main application window
    */
    private Stage stage;
    /**
        Switching between the FXML views
    */
    private Scene scene;
    /**
        Root node in loading the new FXML
    */
    private Parent root;
    
    /**
        Reference to the product list in searching and filtering.
    */
    private products myProds;
    
    /**
     * Constructor for the Controller class
     */
    public Controller() {
        System.out.println("This was from the controller class");
    	//myProds = new products();
    	//myProds.attempt("this should theortically print"); 
    }
    /**
        Handles the logo button clicked from the navigation bar
        Navigates the user back to the homepage

        @param event ActionEvent triggered by the logo button
    */
    @FXML
    private void handleLogoHomePage(ActionEvent event) {
    	System.out.println("Logo clicked!");
        createScene(event, "homepage.fxml");
    }
    /**
        Handles the cart button and switches to the shopping cart page.
        @param event ActionEvent is triggered by the cart button.
    */
    @FXML
    private void handleCartClick(ActionEvent event) {
        System.out.println("Cart clicked!");
        createScene(event, "cartPage.fxml");
    }

    /**
        Handle click to the account button
        @param event ActionEent the button that is clicked by the account button.
    */
    @FXML
    private void handleAccountClick(ActionEvent event) {
        System.out.println("Account clicked!");
        createScene(event, "LoginPage.fxml");
        
    }
    /**
        Handles click to return to homepage
        @param event ActionEvent is the button that is clicked by the Homepage button
    */
    @FXML
    private void handleBackToHomepageClick(ActionEvent event) {
        System.out.println("Back!");
        createScene(event, "Homepage.fxml");
        
    }
    /**
        Triggered when the login button is clicked
        @param event ActionEvent button is clicked by the login button 
    */
    @FXML
    private void userLogin(ActionEvent event) {
    	checkLogin(event);
    }
    
    /**
        Validates user login credentials and displays the feedback and switches to the AdminPage if valid or invalid.
        @param event in ActionEvent is triggered by the login attempt.
    */
    private void checkLogin(ActionEvent event) {
    	if(loginEmail.getText().toString().equals("Admin") && loginPassword.getText().toString().equals("123")) {
    		wrongPasswordLabel.setText("Success!");
    		createScene(event, "AdminPage.fxml");
    		
    	}
    	else if(loginEmail.getText().isEmpty() && loginPassword.getText().isEmpty()){
    		wrongPasswordLabel.setText("Please enter your data.");
    	}
    	else {
    		wrongPasswordLabel.setText("Wrong email or password! Try again");
    	}
    }
    /**
        Logs the user out and returns to the homepage
        @param event is triggered by the logout button
    */
    @FXML
    private void userLogout(ActionEvent event) {
    	createScene(event, "Homepage.fxml");
    }
    /**
        Leads the user to the Keyboards page
        @param event is triggered by the keybord button
    */
    @FXML
    private void handleKeyboardsClick(ActionEvent event) {
        System.out.println("Keyboards clicked!");
        createScene(event, "keyboardPage.fxml");
    }
    /**
        Leads the user to the Keycaps page
        @param event is triggered by the keykaps button
    */
    @FXML
    private void handleKeycapsClick(ActionEvent event) {
        System.out.println("Keycaps clicked!");
        createScene(event, "keycaps.fxml");
    }
    /**
        Leads the user to the Switches page
        @param event is triggered by the switches button        
    */
    @FXML
    private void handleSwitchesClick(ActionEvent event) {
        System.out.println("Switches clicked!"); 
        createScene(event, "switchPage.fxml");
    }
    
    /**
     * Loads a new scene in switching the root from the main scene
     * @param eve ActionEvent is being triggered by the button being clicked
     * @param fileName fileName from the FXML is to be loaded
     */
    public void createScene(ActionEvent eve, String fileName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fileName));
            Stage stage = Main.getPrimaryStage();
            Scene scene = Main.getMainScene();
            if (root instanceof Region) {
                Region regionR = (Region) root;
                regionR.prefWidthProperty().bind(stage.widthProperty());
                regionR.prefHeightProperty().bind(stage.heightProperty());
            }
            scene.setRoot(root);
            stage.setFullScreen(true);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   /**
        A setter that sets the stage 
        @param stage sets the stage
   */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    
//    private void setChosenProduct(products.product prod) {
//        productLabel.setText(prod.getName());
//        priceLabel.setText("$" + prod.getPrice());
//        Image img = new Image(getClass().getResourceAsStream("/img/" + prod.getImgSrc()));
//        productImg.setImage(img);
//        chosenProductCard.setStyle("-fx-background-color: lightgray; -fx-background-radius: 10;");
//    }
//    
    
    
    /**
     * Void method that is meant to switch the scene
     */
    public void switchScene() {
    	stage.setScene(new Scene(new Label("New Scene")));
    }
    
    // ----- CONNECTED TO CUSTOMER.JAVA FOR SEARCH FUNCTION ON THE TOP RIGHT -----
    /**
     * The initialize method runs as a method to load UI elements just as the program is starting
     */
    @FXML
    private void initialize() {
    	// Adds a listener when entering
    	searchField.textProperty().addListener((observable, oldValue, newValue) -> {
    		performSearch(newValue);
    	});
    }
    
    /**
        Performs a product search while using a query string such as the product name or ID.
        It displays the corresponding feedback and switches to AdminPage if found valid.

        @param event ActionEvent is triggered by the login attempt.
    */
    private void performSearch(String query) {
    	//Cleans old search results
    	searchResultsBox.getChildren().clear();
    	
    	//Getting the search entered by the user
    	query = searchField.getText().trim().toLowerCase();
    	
    	//If the search is empty, return
    	if (query == null || query.trim().isEmpty()) {
    		return;
    	}
    	
    	//Get all products from products.java
    	ArrayList<products.product> allProducts = myProds.getAllProducts();
    	
    	//List to hold matched products
    	ArrayList<products.product> matches = new ArrayList<>();
    	
    	try {
    		int idSearch = Integer.parseInt(query);
    		for (products.product p : allProducts) {
    			if (p.getprodID() == idSearch) {
    				matches.add(p);
    			}
    		}
    	} catch (NumberFormatException e) {
    		//Not a number
    		for (products.product p : allProducts) {
    			if (p.getName().toLowerCase().contains(query)) {
    				matches.add(p);
    			}
    		}
    	}
    	
    	//Display results in the Vbox
    	if (matches.isEmpty() ) {
    		searchResultsBox.getChildren().add(new Label("No products found."));
    	} else {
    		for (products.product p : matches) {
    			//Create label for each product
    			Label resultLabel = new Label(p.getName());
    			
    			//Result clickable
    			resultLabel.setOnMouseClicked(event -> {
    				System.out.println("Clicked on: " + p.getName());
    				});
    			
    			//Adding to Vbox
    			searchResultsBox.getChildren().add(resultLabel);
    		}
    	}
    	 /*
         * If "red" is typed:
         * 
         * Found products:
         * - red Mechanical 
         * - cherry mx red 
         * - cherry mx silent red (ID: 6, Price: $18.5)
         * 
         *  If "7" is typed:
         *  FOund products:
         *  - cherry mx brown (ID: 7, Price: $17)
         */
    }
}