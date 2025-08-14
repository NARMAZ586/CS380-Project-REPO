package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import Company.products;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller extends SceneController {

    @FXML private Button btnKeyboards;
    @FXML private Button btnKeycaps;
    @FXML private Button btnSwitches;
    @FXML private Button btnCart;
    @FXML private Button btnAccount;
    @FXML private Button btnKeyCaps;
    @FXML private TextField searchField;
    @FXML private VBox searchResultsBox;
   // @FXML private Button logoBtn;
    
    @FXML private TextField loginEmail;
    @FXML private PasswordField loginPassword;
    @FXML private Label wrongPasswordLabel;
    @FXML private Button logoutBtn;
    
    //fx:id for switchpage
    @FXML private Label priceLabel;
    @FXML private ImageView productImg;
    @FXML private Label productLabel; 
    @FXML private ImageView switchImg;
    @FXML private Label switchNameLabel;  
    @FXML private Label switchPriceLabel;
    @FXML private VBox chosenProductCard;
    @FXML private GridPane grid;
    @FXML private ScrollPane scroll;

    @FXML private ImageView imageView;
    
    private Stage stage;
   // private Scene scene;
    //private Parent root;
    
    private products myProds;
    
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

   
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    
    
    public void switchScene() {
    	stage.setScene(new Scene(new Label("New Scene")));
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