package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class SceneController {
	
	
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
     * Leads the user to the checkout page
     * @param event Triggered when the user clicks checkout button on the shopping cart page
     */
    @FXML
    protected void handleCheckOutClick(ActionEvent event) {
    	System.out.println("Checkout clicked");
    	createScene(event, "Checkout.fxml");
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

    
//    /**
//        A setter that sets the stage 
//        @param stage sets the stage
//   */
//    public void setStage(Stage stage) {
//        this.stage = stage;
//    }
//
//    /**
//     * Void method that is meant to switch the scene
//     */
//    public void switchScene() {
//    	stage.setScene(new Scene(new Label("New Scene")));
//    }
    
}
