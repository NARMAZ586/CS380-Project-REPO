package application;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import Company.products.product;
import Company.inventory;
import Company.products;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SearchPageController extends SceneController implements Initializable{
		
	/**
	* Listview which is used in the search method
	*/
	@FXML private ListView<String> listView;
	
    /**
    A text field where the user inputs into the searchbar
     */
	@FXML 
	private TextField searchBar; //keep this one for sure
	
    @FXML private VBox searchResultsBox;
    /**
        Returns user to the homepage
    */
    @FXML private Button logoBtn;
    
    /**
    Button to navigate to the keyboards page
     */
    @FXML private Button btnKeyboards;
    
    /**
    Button to navigate to the switches page
     */
    @FXML private Button btnSwitches;

    /**
    Button to navigate to the keycaps page
     */
    @FXML private Button btnKeycaps;
    
    /**
    Button to navigate to the shopping cart page
     */
    @FXML private Button btnCart;
    /**
     * Constructor for the Controller class
     */
    
    /**
    Button to navigate to the account user page
     */
    @FXML private Button btnAccount;
    
    
    @FXML private Label searchProductLabel;
    
    @FXML private Label searchPriceLabel;
    
    @FXML private ImageView searchSwitchImg;
    
    @FXML private Button addToCartBtn;
    
    @FXML private Label productStockLabel;
   
    
	public SearchPageController() {
	}
	
	
	///////////////FOR SEARCHING IN THE SEARCH FUNCTION

	/**
     * creates an array list from keyboards, keypads, and switches
     */
	ArrayList<product> allProducts = new ArrayList<>();
	
	
    /**
     *when clicked, it clears and makes a new search results
     *@param event when the button "search" is clicked*/
	@FXML private void search() {
		String keyword = searchBar.getText().toLowerCase();
		
		ObservableList<String> matches = FXCollections.observableArrayList();
		for (product p : allProducts) {
			if (p.getName().toLowerCase().contains(keyword)) {
				matches.add(p.getName());
			}
		}
		listView.setItems(matches);
	}
    /**
     * The initialize method runs as a method to load UI elements just as the program is starting
     * @param URL program starting
     * @param resourceBundle gathers the resources
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	//inventory.InitialProducts();
    	allProducts.addAll(inventory.getAllProducts());
    	
    	listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
    		if (newVal != null ) {
    			for (product p : allProducts) {
    				if (p.getName().equals(newVal)) {
    					searchProductLabel.setText(p.getName());
    					searchPriceLabel.setText("$" + p.getPrice());
    					searchSwitchImg.setImage(new Image(getClass().getResourceAsStream("/img/" + p.getImgSrc())));
    					break;
    				}
    			}
    		}
    	});
    }
}