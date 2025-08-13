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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Company.products.product;
import Company.products;
import Company.customer;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller /*implements Initializable*/{

    @FXML private Button btnKeyboards;
    @FXML private Button btnKeycaps;
    @FXML private Button btnSwitches;
    @FXML private Button btnCart;
    @FXML private Button btnAccount;
    @FXML private Button btnKeyCaps;
    @FXML private TextField searchField;
    @FXML private Button logoBtn;
    
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
    private Scene scene;
    private Parent root;
    
    private products myProds;
    public Controller() {
        System.out.println("This was from the controller class");
    	//myProds = new products();
    	//myProds.attempt("this should theortically print"); 
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
    /*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("This was from the initialize class");
    	myProds = new products(); // initialize product data
        ArrayList<product> allProducts = new ArrayList<>();
        //var allProducts = myProds.getAllProducts();
        allProducts = myProds.getAllProducts();

        if (!allProducts.isEmpty()) {
            //setChosenProduct(allProducts.get(0));
            
        }

        int column = 0;
        int row = 0;
        int i = 1;
        System.out.print(i + " loader test\n");
        i++;

        try {
            for (products.product prod : allProducts) {
                System.out.println(prod.getName());
            	//FXMLLoader loader = new FXMLLoader();
                //loader.setLocation(getClass().getResource("productItem.fxml"));
                //FXMLLoader loader = new FXMLLoader(getClass().getResource("productItem.fxml"));
                FXMLLoader loader = new FXMLLoader(getClass().getResource("productItem.fxml"));
                //loader.setController(this); // Use the existing controller instance
                //Parent root = loader.load();

                //System.out.print("fun");
            	AnchorPane pane = loader.load();

                ProductItemController itemController = loader.getController();
            	// Assuming fxml has these fx:id values
                itemController.setProductName(prod.getName());
                itemController.setPrice("$" + prod.getPrice());
            	//Label nameLabel = (Label) pane.lookup("#productLabel");
            	//Label priceLabel = (Label) pane.lookup("#priceLabel");
            	//ImageView imageView = (ImageView) pane.lookup("#imgSrc");

            	// Set the values
            	//nameLabel.setText(prod.getName());
            	//priceLabel.setText("$" + prod.getPrice());
            	Image img = new Image(getClass().getResourceAsStream( prod.getImgSrc()));
                itemController.setImage(img);
            	//imageView.setImage(img);

                grid.add(pane, column, row);
                column++;
                if (column == 3) {
                    column = 0;
                    row++;
                }
                /*
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);*/

                //AnchorPane.setMargin(pane, new javafx.geometry.Insets(10));
            /*}
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }*/
    
//    private void setChosenProduct(products.product prod) {
//        productLabel.setText(prod.getName());
//        priceLabel.setText("$" + prod.getPrice());
//        Image img = new Image(getClass().getResourceAsStream("/img/" + prod.getImgSrc()));
//        productImg.setImage(img);
//        chosenProductCard.setStyle("-fx-background-color: lightgray; -fx-background-radius: 10;");
//    }
//    
    
    
    
}