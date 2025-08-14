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
import javafx.scene.control.ListView;
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
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
        A text field where the user inputs into the searchbar
    */
    @FXML 
    private TextField searchBar; //keep this one for sure
    
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

    /**
    * Listview which is used in the search method
    */
    @FXML private ListView<String> listView;
    
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
    	myProds = new products();
    	myProds.attempt("this should theortically print");
    	
    	words = new ArrayList<>();
    	for(products.product p : myProds.getAllProducts()) {
    		words.add(p.getName());
    	}
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
        Leads the user to the search page
        @param event is triggered by the search button
    */
    @FXML
    private void handleSearchClick(ActionEvent event) {
        System.out.println("Search clicked!");
        createScene(event, "searchPage.fxml");
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

    
    //Contains the names from product.java (keyboards, keypads, and switches)
    /**
     * creates an array list from keyboards, keypads, and switches
     */
    ArrayList<String> words = new ArrayList<>(Arrays.asList());
    
    //Clicks the button

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
    	listView.setVisible(false);
    	
    	words.clear();
    	for (products.product p : myProds.getAllProducts()) {
    		words.add(p.getName());
    	}
    	
    	searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.isEmpty()) {
    			listView.getItems().clear();
    			listView.setVisible(false);
    		} else {
    			List<String> results = searchList(newValue, words);
    			listView.getItems().setAll(results);
    			listView.setVisible(!results.isEmpty());
    		}
    	});
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