package application;

import Company.inventory;
import Company.products.product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
AdminPageController
Date of code: 8/15/25
This controller class handles all of the UI elements of the Admin page
This includes things like adding account, adding stock, remove stock
@author Marlon Santana
*/
public class AdminPageController extends SceneController{
    /**
    Returns user to the homepage
     */
	@FXML private Button logoBtn;
	
    /**
    Button to navigate to the keyboards page
     */
	@FXML private Button btnKeyboards;
	
    /**
    Button to navigate to the switches page
     */
	@FXML private Button btnSwitches;
	
    /**
    Button to navigate to the keycaps page
     */
	@FXML private Button btnKeyCaps;
	
	/**
	 * Button that leats to the search page*/
	@FXML private Button btnSearch;
	
    /**
    Button used to logout the user and return to the homepage
     */
	@FXML private Button logoutBtn;
	
	/**
	 * Button that adds an account and stores it in account.java
	 */
	@FXML private Button btnAddAccount;
	/**
	 * TextField that the user enters their email
	 */
	@FXML public TextField txtFieldAdminPageEmail;
	/**
	 * TextField that the users enters their username
	 */
	@FXML public TextField txtFieldAdminPageUsername;
	/**
	 * TextField that the users enters their password
	 */
	@FXML public TextField txtFieldAdminPagePassword;
	/**
	 * TableView that brings the products to this page to display
	 */
	@FXML public TableView<product> tblViewProductStock;
	/**
	 * TableColumn that showcases the name of the product
	 */
	@FXML public TableColumn<product, String> tblColumnProductName;
	/**
	 * TableColumn that shows the  Product quantities
	 */
	@FXML public TableColumn<product, Integer> tblColumnQuantity;
	/**
	 * Button that removes the stock quantity by 1
	 */
    @FXML public Button btnRemoveStock;
    /**
     * Button that adds the stock quantity by 1
     */
    @FXML public Button btnAddStock;
    /**
     * Observable list that brings the productList and put it in an Array List
     */
    public ObservableList<product> productList = FXCollections.observableArrayList();
    /**
     * Logs out the user and to the homepage
     * @param event leads to the Homepage when pressed
     */
    @FXML private void userLogout(ActionEvent event) {
    	createScene(event, "Homepage.fxml");
    }
	/**
	 * Controller for the admin page
	 */
	public AdminPageController() {}
	/**
	 * initializes the Admin Page
	 */
	@FXML public void initialize() {
		//inventory.InitialProducts();
		productList.addAll(inventory.getAllProducts());
		
		tblColumnProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("stockQuantity"));

        tblViewProductStock.setItems(productList);
	}
	/**
	 * When pressed it adds a stock
	 * @param event Adds the stock by 1
	 */
	@FXML public void handleBtnAddStock(ActionEvent event) {
		product selected = tblViewProductStock.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStockQuantity(selected.getStockQuantity() + 1);
            tblViewProductStock.refresh();
        }
	}
	/**
	 * When pressed it removes a stock
	 * @param event Removes the stock by 1
	 */
	@FXML public void handleBtnRemoveStock(ActionEvent event) {
		product selected = tblViewProductStock.getSelectionModel().getSelectedItem();
        if (selected != null && selected.getStockQuantity() > 0) {
            selected.setStockQuantity(selected.getStockQuantity() - 1);
            tblViewProductStock.refresh();
        }
	}
	/**
	 * When pressed it adds the account
	 * @param event gets email, username, password to the storage
	 */
	@FXML public void handleBtnAddAccount(ActionEvent event) {
		String email = txtFieldAdminPageEmail.getText().trim();
		String username = txtFieldAdminPageUsername.getText().trim();
	    String password = txtFieldAdminPagePassword.getText().trim();
	    
	    if (!email.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
	    	Company.account.addAccount(new Company.account(email, password, username));
	    	account.writeSingleAccounts();
	    	System.out.println("New account created: " + email);
	    	txtFieldAdminPageEmail.clear();
	    	txtFieldAdminPageUsername.clear();
	    	txtFieldAdminPagePassword.clear();
	    }
	}
	
	//IF THERE'S TIME, CREATE FEATURE ADD PRODUCTS
}
