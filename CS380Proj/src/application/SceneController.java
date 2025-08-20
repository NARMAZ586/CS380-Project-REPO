package application;
import java.io.IOException;

import Company.ShoppingCart;
import Company.products.product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
/**
SceneController
Date of code: 8/15/25
This controller class handles all of the Scenes
This includes things like moving scenes from one fxml to another or have interactions with the UI
@author Nery A.
*/
/**
 * class of the scene controller
 */
public class SceneController {
	/**
	 * default constructor of SceneController
	 */
	public SceneController() {}
	/**
	 * Displays the shopping cart result label
	 */
	@FXML private Label shoppingCartResultLabel;
	/**
    Handles the logo button clicked from the navigation bar
    Navigates the user back to the homepage
    @param event ActionEvent triggered by the logo button
    */
	@FXML
	protected void handleLogoHomePage(ActionEvent event) {
    	System.out.println("Logo clicked!");
        createScene(event, "homepage.fxml");
    }
	
	/**
    Handles the cart button and switches to the shopping cart page.
    @param event ActionEvent is triggered by the cart button.
    */
    @FXML
    protected void handleCartClick(ActionEvent event) {
        System.out.println("Cart clicked!");
        createScene(event, "cartPage.fxml");
    }
    
    /**
    Handle click to the account button
    @param event ActionEent the button that is clicked by the account button.
    */
    @FXML
    protected void handleAccountClick(ActionEvent event) {
        System.out.println("Account clicked!");
        createScene(event, "LoginPage.fxml");
    }
    
    /**
    Handles click to return to homepage
    @param event ActionEvent is the button that is clicked by the Homepage button
    */
    @FXML
    protected void handleBackToHomepageClick(ActionEvent event) {
    System.out.println("Back!");
    createScene(event, "Homepage.fxml");
    }
    
    /**
    Leads the user to the search page
    @param event is triggered by the search button
    */ @FXML
    protected void handleSearchClick(ActionEvent event) {
    System.out.println("Search clicked!");
    createScene(event, "searchPage.fxml");
    }

    
    /**
        Leads the user to the Keyboards page
        @param event is triggered by the keybord button
    */
    @FXML
    protected void handleKeyboardsClick(ActionEvent event) {
        System.out.println("Keyboards clicked!");
        createScene(event, "keyboardPage.fxml");
    }

    /**
        Leads the user to the Keycaps page
        @param event is triggered by the keykaps button
    */
    @FXML
    protected void handleKeycapsClick(ActionEvent event) {
        System.out.println("Keycaps clicked!");
        createScene(event, "keycaps.fxml");
    }

    /**
        Leads the user to the Switches page
        @param event is triggered by the switches button        
    */
    @FXML
    protected void handleSwitchesClick(ActionEvent event) {
        System.out.println("Switches clicked!"); 
        createScene(event, "switchPage.fxml");
    }
    
    /**
    
    Leads the user to the checkout page
    @param event Triggered when the user clicks checkout button on the shopping cart page*/@FXML
    protected void handleCheckOutClick(ActionEvent event) {
    	System.out.println("Checkout clicked");
    	if (ShoppingCart.getCartItems().isEmpty()) {
    		shoppingCartResultLabel.setText("Your cart is empty");
    		System.out.println("Your cart is empty");
    	} else if(shoppingCartController.getShippingMethod() == null) {
    		shoppingCartResultLabel.setText("Select a shipping method");
    		System.out.println("Please select a shipping method first");
    	} else {
    		createScene(event, "Checkout.fxml");
    	}
    }
    
    
    
    /**
     * Loads a new scene in switching the root from the main scene
     * @param eve ActionEvent is being triggered by the button being clicked
     * @param fileName fileName from the FXML is to be loaded
     */
    protected void createScene(ActionEvent eve, String fileName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fileName));
            Stage stage = Main.getPrimaryStage();
            Scene scene = Main.getMainScene();
            if (root instanceof Region regionR) {
            	//stage.setWidth(regionR.prefWidth(-1));
            	//stage.setHeight(regionR.prefHeight(-1));
            	
                //Region regionR = (Region) root;
                regionR.prefWidthProperty().bind(stage.widthProperty());
                regionR.prefHeightProperty().bind(stage.heightProperty());
            }
            scene.setRoot(root);
            //stage.setFullScreen(true);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Parent currentRoot = Main.getMainScene().getRoot();
        if (currentRoot.getUserData() != null && currentRoot.getUserData() instanceof shoppingCartController) {
            ((shoppingCartController) currentRoot.getUserData()).resetShipping();
        }
    }
    
    
    /**
     * Variable used to store selected product from grid, and used to add to cart
     */
    protected product selectedProduct;
    /**
     * variable used to store the quantity of the product
     */
    protected int quantity;
    
    /**
     * button for product page add to cart.
     */
    @FXML
    protected Button btnAddToCart;
    /**
     * displays the stock label of the product
     */
    @FXML
    protected Label productStockLabel;
    
    /**
     * Updates the label based on the stock of the selected product card.
     * @param prod gets the stock quantity from the product
     */
    protected void updateStockLabel(product prod) {
        if (prod.getStockQuantity() > 0) {
            productStockLabel.setText("In Stock: " + prod.getStockQuantity());
            if (btnAddToCart != null) btnAddToCart.setDisable(false);
        } else {
            productStockLabel.setText("Sold Out");
            if (btnAddToCart != null) btnAddToCart.setDisable(true);
        }
    }
    
    /**
     * textfield for quantityfield in product page vbox display
     */
    @FXML
    protected TextField quantityField;
    
    /**
     * Called when "Add to Cart" button is pressed.
     */
    @FXML
    protected void handleAddToCart() {
    	if (selectedProduct == null) {
    		System.out.println("No Product selected.");
    		return;
    	}

        int requestedQty = 1; // default
        try {
            if (quantityField != null && !quantityField.getText().isEmpty()) {
                requestedQty = Integer.parseInt(quantityField.getText());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity entered.");
            quantityField.setText("1");
            return;
        }

        if (requestedQty <= 0) {
            System.out.println("Quantity must be at least 1.");
            quantityField.setText("1");
            return;
        }

        int stock = selectedProduct.getStockQuantity();
        if (stock >= requestedQty) {
            ShoppingCart.addItem(selectedProduct, requestedQty);
            selectedProduct.setStockQuantity(stock - requestedQty);
            updateStockLabel(selectedProduct);
            System.out.println("This is the stock of " + selectedProduct.getName() + ": " + stock);
            quantityField.setText(""); // clear after adding
        } else {
            System.out.println("Not enough stock available.");
            quantityField.setText(String.valueOf(stock));
        }
    }
    
    /**
     * Sets selected product in product selection page
     * @param p constructor for the product in scene controller
     */
    public void setSelectedProduct(product p) {
        this.selectedProduct = p;
    }
    
    /**
     * not used but useful for getting product info that has been selected
     * @return retunrs to the selected product
     */
    public product getSelectedProduct() {
        return this.selectedProduct;
    }

}
