package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;


import Company.products;
import Company.products.product;

import application.Controller;

/** 
 * SwitchPageController
 * 08/12/2025
 * @author Matthew Berleson
 * 
 * Class Description:Class is meant to be a controller for the switch product page that displays products and adds them to shopping cart.
 * 
 * Important Functions:
 * intializes(): intializes product list and loads product cards into grid
 * handleAccountClick(), handleCartClick(), etc... : Handles navigation on mouse click
 * 
 * DataStructures:
 * ArrayList<product>: used to hold product objects
 * GridPane: Layout to display product cars in a grid
 */

public class SwitchPageController implements Initializable{
    private products myProds;

	@FXML
    private Button btnAccount;

    @FXML
    private Button btnCart;

    @FXML
    private Button btnKeyCaps;

    @FXML
    private Button btnKeyboards;

    @FXML
    private Button btnSwitches;

    @FXML
    private VBox chosenProductCard;

    @FXML
    private GridPane grid;

    @FXML
    private Button logoBtn;

    @FXML
    private ScrollPane scroll;

    @FXML
    private TextField searchField;

    @FXML
    private ImageView switchImg;

    @FXML
    private Label switchNameLabel;

    @FXML
    private Label switchPriceLabel;

    //@FXML 
    //private ImageView imageView;


    /**
     *Handles actions when account is clicked.
     *@param event, an ActionEvent triggered by button click
     */
    @FXML
    void handleAccountClick(ActionEvent event) {

    }

    /**
     *Handles actions when cart is clicked.
     *@param event, an ActionEvent triggered by button click
     */
    @FXML
    void handleCartClick(ActionEvent event) {

    }

    /**
     *Handles actions when keyboards is clicked.
     *@param event, an ActionEvent triggered by button click
     */
    @FXML
    void handleKeyboardsClick(ActionEvent event) {

    }

    /**
     *Handles actions when Keycaps is clicked.
     *@param event, an ActionEvent triggered by button click
     */
    @FXML
    void handleKeycapsClick(ActionEvent event) {

    }

    /**
     *Handles actions when Hompage Logo is clicked.
     *@param event, an ActionEvent triggered by button click
     */
    @FXML
    void handleLogoHomePage(ActionEvent event) {

    }

    @FXML
    void handleSwitchesClick(ActionEvent event) {
    	
    }


    /**
     *Intializes controller, loads products and dynamically adds product cards to grid UI
     *@param location
     *@param resources
     */
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("This was from the initialize class");
    	myProds = new products(); // initialize product data
        ArrayList<product> allProducts = new ArrayList<>();
        //var allProducts = myProds.getAllProducts();
        allProducts = myProds.getAllProducts();

        if (!allProducts.isEmpty()) {
            //setChosenProduct(allProducts.get(0));
            
        }
        
        for (int i = 0; i < 2; i++) { // 3 columns
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(33.33); // divide grid width equally
            grid.getColumnConstraints().add(col);
        }

    
        RowConstraints rowConst = new RowConstraints();
        rowConst.setMinHeight(220); // height for each product card
        grid.getRowConstraints().add(rowConst);

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

                GridPane.setMargin(pane, new javafx.geometry.Insets(10));
                column++;
                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                
                
               // GridPane.setMargin(grid, new javafx.geometry.Insets(10)); //not sure what it does but doesn't seem to be harmful
                //AnchorPane.setMargin(pane, new javafx.geometry.Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
         
    }
}
