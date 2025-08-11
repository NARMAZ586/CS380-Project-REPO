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

public class Controller /*implements Initializable*/{

    @FXML private Button btnKeyboards;
    @FXML private MenuButton btnKeycaps;
    @FXML private Button btnSwitches;
    @FXML private Button btnCart;
    @FXML private Button btnAccount;
    @FXML private TextField searchField;
    //@FXML private HBox mainImageContainer;
    //@FXML private ImageView mainImage;
    /*@FXML private HBox secondContainer;
    @FXML private ImageView secondImageView;
    @FXML private HBox thirdContainer;
    @FXML private ImageView thirdImageView;
    @FXML private HBox bottomImageRow;
    @FXML private VBox mainVBox;*/
    
    @FXML private TextField loginEmail;
    @FXML private PasswordField loginPassword;
    @FXML private Label wrongPasswordLabel;
    
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
    private void handleCartClick() {
        System.out.println("Cart clicked!");
    }

    @FXML
    private void handleAccountClick(ActionEvent event) {
        System.out.println("Account clicked!");
        
        try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    @FXML
    private void handleBackToHomepageClick(ActionEvent event) {
        System.out.println("Back!");
        
        try {
			Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    @FXML
    private void userLogin(ActionEvent event) {
    	checkLogin();
    }
    
    private void checkLogin() {
    	
    	
    	if(loginEmail.getText().toString().equals("Admin@example.com") && loginPassword.getText().toString().equals("password")) {
    		wrongPasswordLabel.setText("Success!");
    		
    		
    	}
    	else if(loginEmail.getText().isEmpty() && loginPassword.getText().isEmpty()){
    		wrongPasswordLabel.setText("Please enter your data.");
    	}
    	else {
    		wrongPasswordLabel.setText("Wrong email or password! Try again");
    	}
    }

    @FXML
    private void handleKeyboardsClick() {
        System.out.println("Keyboards clicked!");
    }

    @FXML
    private void handleKeycapsClick() {
        System.out.println("Keycaps clicked!");
    }

    @FXML
    private void handleSwitchesClick() {
        System.out.println("Switches clicked!");
        //store s = new store();
        product p = new product();
        
 
    }
    
    
    /*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	mainImage.fitWidthProperty().bind(mainImageContainer.widthProperty());
    	mainImage.fitHeightProperty().bind(mainImageContainer.heightProperty());
    	
    	secondImageView.fitWidthProperty().bind(secondContainer.widthProperty());
    	secondImageView.fitHeightProperty().bind(secondContainer.heightProperty());
    	
    	thirdImageView.fitWidthProperty().bind(thirdContainer.widthProperty());
    	thirdImageView.fitHeightProperty().bind(thirdContainer.heightProperty());
    	
    	HBox.setHgrow(mainImageContainer,  Priority.ALWAYS);
    	VBox.setVgrow(bottomImageRow,  Priority.SOMETIMES);
    	HBox.setHgrow(secondContainer, Priority.ALWAYS);
    	HBox.setHgrow(thirdContainer, Priority.ALWAYS);
    	
    }*/

    
    private double clamp(double value, double min, double max) {
    	return Math.max(min, Math.min(value,  max));
    }
    
    
    
    
    
    
    
    
    
    
}