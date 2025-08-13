package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Company.products.product;
import Company.products;
import Company.customer;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller{

    @FXML private Button btnKeyboards;
    @FXML private Button btnKeycaps;
    @FXML private Button btnSwitches;
    @FXML private Button btnCart;
    @FXML private Button btnAccount;
    @FXML private Button btnKeyCaps;
    @FXML private TextField searchField;
    @FXML private VBox searchResultsBox;
    @FXML private Button logoBtn;
    
    @FXML private TextField loginEmail;
    @FXML private PasswordField loginPassword;
    @FXML private Label wrongPasswordLabel;
    @FXML private Button logoutBtn;
    
    
    
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private products myProds;
    public Controller() {
    	myProds = new products();
    	myProds.attempt("this should theortically print");
    }
    //buttons
    @FXML
    private void handleLogoHomePage(ActionEvent event) {
    	System.out.println("Logo clicked!");
        createScene(event, "homepage.fxml");
    }
    @FXML
    private void handleCartClick(ActionEvent event) {
        System.out.println("Cart clicked!");
        createScene(event, "cartPage.fxml");
    }

    @FXML
    private void handleAccountClick(ActionEvent event) {
        System.out.println("Account clicked!");
        createScene(event, "LoginPage.fxml");
        
    }
    
    @FXML
    private void handleBackToHomepageClick(ActionEvent event) {
        System.out.println("Back!");
        createScene(event, "Homepage.fxml");
        
    }
    
    @FXML
    private void userLogin(ActionEvent event) {
    	checkLogin(event);
    }
    
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
    
    @FXML
    private void userLogout(ActionEvent event) {
    	createScene(event, "Homepage.fxml");
    }

    @FXML
    private void handleKeyboardsClick(ActionEvent event) {
        System.out.println("Keyboards clicked!");
        createScene(event, "keyboardPage.fxml");
    }

    @FXML
    private void handleKeycapsClick(ActionEvent event) {
        System.out.println("Keycaps clicked!");
        createScene(event, "keycaps.fxml");
    }

    @FXML
    private void handleSwitchesClick(ActionEvent event) {
        System.out.println("Switches clicked!"); 
        createScene(event, "switchPage.fxml");
    }
    
    
    private void createScene(ActionEvent eve,String fileName) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource(fileName));
			stage = (Stage)((Node)eve.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // ----- CONNECTED TO CUSTOMER.JAVA FOR SEARCH FUNCTION ON THE TOP RIGHT -----
    @FXML
    private void initialize() {
    	// Adds a listener when entering
    	searchField.textProperty().addListener((observable, oldValue, newValue) -> {
    		performSearch(newValue);
    	});
    }
    
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