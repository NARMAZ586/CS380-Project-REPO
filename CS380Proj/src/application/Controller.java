package application;

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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller{

    @FXML private Button btnKeyboards;
    @FXML private Button btnKeycaps;
    @FXML private Button btnSwitches;
    @FXML private Button btnCart;
    @FXML private Button btnAccount;
    @FXML private Button btnKeyCaps;
    @FXML private TextField searchBar;
    @FXML private VBox searchResultsBox;
    @FXML private Button logoBtn;
    
    @FXML private TextField loginEmail;
    @FXML private PasswordField loginPassword;
    @FXML private Label wrongPasswordLabel;
    @FXML private Button logoutBtn;
    @FXML private ListView<String> listView;
    
    
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private products myProds;
    public Controller() {
    	myProds = new products();
    	myProds.attempt("this should theortically print");
    	
    	words = new ArrayList<>();
    	for(products.product p : myProds.getAllProducts()) {
    		words.add(p.getName());
    	}
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
    
    @FXML
    private void handleSearchClick(ActionEvent event) {
        System.out.println("Search clicked!");
        createScene(event, "searchPage.fxml");
    }

    
    private void createScene(ActionEvent eve, String fileName) {
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
   
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void switchScene() {
    	stage.setScene(new Scene(new Label("New Scene")));
    }
    
    // ----- CONNECTED TO CUSTOMER.JAVA FOR SEARCH FUNCTION ON THE TOP RIGHT -----
    
    //Contains the names from product.java (keyboards, keypads, and switches)
    ArrayList<String> words = new ArrayList<>(Arrays.asList());
    
    //Clicks the button
    @FXML
    void search(ActionEvent event) {
        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBar.getText(),words));
    }//when clicked, it clears and makes a new
    
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
    
    
    private List<String> searchList(String searchWords, List<String> listOfStrings) {
        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));
        
        return listOfStrings.stream().filter(input -> { //input = test
            return searchWordsArray.stream().allMatch(word -> //word = te
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
}