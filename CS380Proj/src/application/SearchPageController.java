package application;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import Company.products.product;
import Company.products;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SearchPageController extends SceneController{

    /**
    Reference to the product list in searching and filtering.
     */
	private products myProds;
	
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
    
    @FXML private Button searchAddToCart;
    
	public SearchPageController() {
    	myProds = new products();
    	myProds.attempt("this should theortically print");
    	
	}

	
	
	///////////////FOR SEARCHING IN THE SEARCH FUNCTION

	/**
     * creates an array list from keyboards, keypads, and switches
     */
	ArrayList<String> words = new ArrayList<>(Arrays.asList());
	
	
    /**
     *when clicked, it clears and makes a new search results
     *@param event when the button "search" is clicked*/
    @FXML
    void search(ActionEvent event) {
        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBar.getText(),words));
    }
    
    /**
     * The initialize method runs as a method to load UI elements just as the program is starting
     * @param URL program starting
     * @param resourceBundle gathers the resources
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	listView.getItems().addAll(words);
    }
    
    /**
     * inputs and outputs are tracked and leads to the search bar
     * @param searchWords to search the words from the bar
     * @param listOfStrings used for using the input for the words in the listView
     * @return returns the words to the ListView
     * */
    private List<String> searchList(String searchWords, List<String> listOfStrings) {
    	
        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));
        
        return listOfStrings.stream().filter(input -> { //input = test
            return searchWordsArray.stream().allMatch(word -> //word = te
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
}
