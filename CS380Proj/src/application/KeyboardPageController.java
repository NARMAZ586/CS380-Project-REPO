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
KeyboardPageController
Date of code: 8/13/25
This controller class handles all of the UI elements of the Keyboard page
This includes things like selecing keyboards and adding to cart depending on quantity
@author Matthew
*/
public class KeyboardPageController extends SceneController implements Initializable{
	/**
	 * default constructor of KeyboardPageController
	 */
	public KeyboardPageController() {}
    //private products myProds = new products();
    /**
    Button to navigate to the account user page
    */
	@FXML
    private Button btnAccount;
    /**
    Button to navigate to the shopping cart page
    */
    @FXML
    private Button btnCart;
    /**
    Button to navigate to the keycaps page
    */
    @FXML
    private Button btnKeyCaps;
    /**
    Button to navigate to the switches page
    */
    @FXML
    private Button btnSwitches;
    /**
    Styles the selected product card
    */
    @FXML
    private VBox chosenProductCard;
    /**
    Places all the product cards in a layout
    */
    @FXML
    private GridPane grid;
    /**
    Returns user to the homepage
    */
    @FXML
    private Button logoBtn;
    /**
    Wraps the product grip used for scrolling
    */
    @FXML
    private ScrollPane scroll;
    /**
    Displays a selected switch image
    */
    @FXML
    private TextField searchField;
    /**
    Displays the selected switch name
    */
    @FXML
    private ImageView switchImg;
    /**
    Displays the selected switch's price
    */
    @FXML
    private Label switchNameLabel;
    /**
     * Displays the selected image
     */
    @FXML
    private Label switchPriceLabel;
    /**
     * Displays the selected image
     */
    private Image img;
    /**
     * tracks the clicks
     */
    private InterfaceListener clickListener;
    /**
     * displays the product stock label
     */
    @FXML
    private Label productStockLabel;
    /**
     * displays the add to cart button
     */
    @FXML
    private Button addToCartBtn;
    /**
     * choose the product of the keyboard
     * @param prod updates the stock label using the chose product
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

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("This was from the initialize class");
    	//myProds = new products(); // initialize product data
        ArrayList<product> allProducts = new ArrayList<>();
        allProducts = inventory.getAllKeyboards();

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
