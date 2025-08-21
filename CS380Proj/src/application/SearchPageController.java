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
/**
SearchPageController
Date of code: 8/15/25
This controller class handles all of the UI elements of the SearchPage page
This includes things like searching products in listView and selecting it display the product and add it
@author Marlon Santana
*/
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
	/**
	 * displays the search results box
	 */
    @FXML private VBox searchResultsBox;
    /**
        Returns user to the homepage
    */
    @FXML private Button logoBtn;
    /**
     * displays the product label
     */
    @FXML private Label searchProductLabel;
    /**
     * displays the price label
     */
    @FXML private Label searchPriceLabel;
    /**
     * displays the image of the search page
     */
    @FXML private ImageView searchSwitchImg;
    /**
     * displays the button on adding to cart
     */
    @FXML private Button addToCartBtn;
    /**
     * displays the stock label
     */
    @FXML private Label productStockLabel;
   
    /**
     * class for the search page controller
     */
	public SearchPageController() {}
	
	/**
     * creates an array list from keyboards, keypads, and switches
     */
	ArrayList<product> allProducts = new ArrayList<>();

    /**
     *when clicked, it clears and makes a new search results
     */
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
     * @param url program starting
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
    /**
     * Opens the product details page for the selected product
     * @param event the action event triggering the navigation
     */
    @FXML private void handleGoToProductDetails(ActionEvent event) {
    	String selectedName = searchProductLabel.getText();
    	if (selectedName == null || selectedName.equals("Product")) {
    		return;
    	}
    	for (product p : allProducts) {
    		if (p.getName().equals(selectedName)) {
    			String type = p.prodType();
    			if (type.equalsIgnoreCase("keyboard")) {
    				createScene(event, "KeyboardPage.fxml");
    			} else if (type.equalsIgnoreCase("switch")) {
    				createScene(event, "switchPage.fxml");
    			} else if (type.equalsIgnoreCase("keycap")) {
    				createScene(event, "keycaps.fxml");
    			}
    			break;
    		}
    	}
    }
}