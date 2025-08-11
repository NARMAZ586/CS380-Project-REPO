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
import java.util.ResourceBundle;
import Company.products.product;
import Company.products;
import Company.customer;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller{

    @FXML private Button btnKeyboards;
    @FXML private MenuButton btnKeycaps;
    @FXML private Button btnSwitches;
    @FXML private Button btnCart;
    @FXML private Button btnAccount;
    @FXML private TextField searchField;
    
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
    private void handleKeycapsClick() {
        System.out.println("Keycaps clicked!");
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
    
}