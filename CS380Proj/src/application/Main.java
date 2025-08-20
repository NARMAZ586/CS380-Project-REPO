package application;
    
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import application.Controller;
import javafx.application.Platform;
import Company.account;
import Company.inventory;
import Company.products;
import application.OrdersController;
import Company.customer;

/**
 * Name: Main
 * Date of code: 7/21/25
 * GUI is displayed from this class
 * @author Nery Armaz, Matthew B., Marlon A., Michelle L.
 * 
 */
public class Main extends Application {
	/**
	 * default constructor of main
	 * */
	public Main() {}
	/**
	 * A private variable for stage, as name implies it is the primary stage for the gui
	 */
    private static Stage primaryStage;
    /**
     * A private variable for scene
     */
    private static Scene mainScene;
    @Override
    /**
     * Method contains everything to load and get the GUI running
     *param stage This parameter is used to load the stage in
     */
    public void start(Stage stage) {
        try {
        	//inventory.InitialProducts();
        	products.readProductsCSV("Database/DefaultProducts.csv");
        	account.readAccountsCSV("Database/Accounts.csv");
        	inventory.writeDefaultInventory();
        	customer.readCustomersCSV();
        	OrdersController.createOrdersCSV();
        	
        	
            primaryStage = stage;
            Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
            mainScene = new Scene(root);
            String css = this.getClass().getResource("application.css").toExternalForm();
            mainScene.getStylesheets().add(css);
            primaryStage.setResizable(false);
            //primaryStage.setFullScreen(true);
            primaryStage.setScene(mainScene);
            //uncomment this if program is not fully closing when you close it out
            /*primaryStage.setOnCloseRequest(e -> {
            	Platform.exit();
            	System.exit(0);
            }); */
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Getter method for primaryStage
     * @return Return is the primaryStage, of type Stage
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    /**
     * Getter method for mainScene
     * @return Return is the mainScene, of type Scene
     */
    public static Scene getMainScene() {
        return mainScene;
    }
    
    /**
     * When program is run through java application it begins at this method
     * @param args Essentially this parameter calls the start method 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}