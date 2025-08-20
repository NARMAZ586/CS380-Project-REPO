package application;


import java.io.IOException;
import java.util.ArrayList;

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
import Company.inventory;
import Company.products;
import Company.products.product;


/** 
 * SwitchPageController
 * 08/12/2025
 * 
 * Class Description:Class is meant to be a controller for the switch product page that displays products and adds them to shopping cart.
 * 
 * Important Functions:
 * intializes(): intializes product list and loads product cards into grid
 * handleAccountClick(), handleCartClick(), etc... : Handles navigation on mouse click
 * 
 * DataStructures:
 * ArrayList product: used to hold product objects
 * GridPane: Layout to display product cars in a grid
 * @author Matthew Berleson
 */
public class SwitchPageController extends SceneController implements Initializable{
	/**
	 * default constructor of SwitchPageController
	 */
	public SwitchPageController() {}
	
    /**
     *Button use for the Account page
     */
	@FXML
    private Button btnAccount;
	/**
	 * Button use for the Cart page
	 */
    @FXML
    private Button btnCart;
    /**
     * Button used for the KeyCaps page
     */
    @FXML
    private Button btnKeyCaps;
    /**
     * Button use for Keyboards page
     */
    @FXML
    private Button btnKeyboards;
    
    /**
     * Button use for the chosen ProductCard page
     */
    @FXML
    private VBox chosenProductCard;
    /**
     * A Grid Pane for the Switch Page
     */
    @FXML
    private GridPane grid;
    /**
     * Button for the Logo that leads to the Homepage
     */
    @FXML
    private Button logoBtn;
    /**
     * ScrollPane that is used for scroll
     */
    @FXML
    private ScrollPane scroll;
    /**
     * Textfield that is used for the searchField
     */
    @FXML
    private TextField searchField;
    /**
     * ImageView that is used for switching images in SwitchPage
     */
    @FXML
    private ImageView switchImg;
    
    /**
    * The label switchNameLabel is used for the item card on switchPage 
    */
    @FXML
    private Label switchNameLabel;
    
    /**
    * The label switchPriceLabel is used for the item card on switchPage 
    */
    @FXML
    private Label switchPriceLabel;

    /**
    * Container Image is used for imgSrc 
    */
    private Image img;
    
    /**
    *  An instance of InterfaceListener, that is used to expect a click from the mouse
    */
    private InterfaceListener clickListener;
    /**
     * displays the stock label of the product
     */
    @FXML
    private Label productStockLabel;
    /**
     * displays the add to car button
     */
    @FXML
    private Button addToCartBtn;
    
    
    /**
     * Method will display the image of the clicked product within the item card
     * @param prod Just an instance of a product from the products class
     */
    private void setChosenProduct(products.product prod) {
    	
    	switchNameLabel.setText(prod.getName());
    	switchPriceLabel.setText("$" + prod.getPrice());
    	img = new Image(getClass().getResourceAsStream("/img/" + prod.getImgSrc()));
    	switchImg.setImage(img);
    	chosenProductCard.setStyle("-fx-background-color: lightgray; -fx-background-radius: 10;");
    	selectedProduct = prod; //saves selected product for add cart
    	updateStockLabel(prod);
    }


    /**
     *Intializes controller, loads products and dynamically adds product cards to grid UI
     *@param location, The location of the URL
     *@param resources Used to access specific resources in the java language
     */
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("This was from the initialize class");
        ArrayList<product> allProducts = new ArrayList<>();
        allProducts = inventory.getallSwitches();

        if (!allProducts.isEmpty()) {
            setChosenProduct(allProducts.get(0));
            
            clickListener = new InterfaceListener() {
                @Override
                public void onActionListener(products.product item) {
                    setChosenProduct(item);
                }
            };
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
        
        try {
            for (products.product prod : allProducts) {
                System.out.println(prod.getName());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("productItem.fxml"));
            	AnchorPane pane = loader.load();

                ProductItemController itemController = loader.getController(); 
                
                
                itemController.setData(prod, clickListener);
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
}
