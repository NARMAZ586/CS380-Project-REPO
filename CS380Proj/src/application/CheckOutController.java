package application;
/**
    CheckOutController
    Date of code: 8/13/25
    This controller class handles all of the UI elements of the CheckOut page
    This includes things like verify if credit card is valid or getting the customer information
    @author Nery Armaz
*/

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Company.products.product;
import Company.products;
import Company.customer;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckOutController /*implements Initializable*/{
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
        Returns user to the home page
    */
    @FXML private Button logoBtn;
    
    /**
        Places all labels and textfields in it
    */
    @FXML private GridPane grid;
    
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
     * Constructor for the CheckOutController class
     */
    public CheckOutController() {
    	myProds = new products();
    	myProds.attempt("this should theortically print");
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
     * Leads the user to the checkout page
     * @param event Triggered when the user clicks checkout button on the shopping cart page
     */
    @FXML
    private void handleCheckOutClick(ActionEvent event) {
    	System.out.println("Checkout clicked");
    	createScene(event, "Checkout.fxml");
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
    
    /**
     * Void method that is meant to switch the scene
     */
    public void switchScene() {
    	stage.setScene(new Scene(new Label("New Scene")));
    }
    
    /**
     * The initialize method runs as a method to load UI elements just as the program is starting
     * @param URL program starting
     * @param resourceBundle gathers the resources
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    }
}
 