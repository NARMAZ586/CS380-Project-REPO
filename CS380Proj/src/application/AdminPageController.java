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
	
	
	@FXML private Button btnSearch;
	
    /**
    Button used to logout the user and return to the homepage
     */
	@FXML private Button logoutBtn;
	
	@FXML private Button btnAddAccount;
	
	@FXML private TextField txtFieldAdminPageEmail;
	
	@FXML private TextField txtFieldAdminPageUsername;
	
	@FXML private TextField txtFieldAdminPagePassword;
	
	@FXML private TableView<product> tblViewProductStock;
	
	@FXML private TableColumn<product, String> tblColumnProductName;
	
	@FXML private TableColumn<product, Integer> tblColumnQuantity;
	
    @FXML private Button btnRemoveStock;
    
    @FXML private Button btnAddStock;
    
    private ObservableList<product> productList = FXCollections.observableArrayList();
    
    @FXML private void userLogout(ActionEvent event) {
    	createScene(event, "Homepage.fxml");
    }
	
	public AdminPageController() {}
	
	@FXML public void initialize() {
		//inventory.InitialProducts();
		productList.addAll(inventory.getAllProducts());
		
		tblColumnProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("stockQuantity"));

        tblViewProductStock.setItems(productList);
	}
	
	@FXML private void handleBtnAddStock(ActionEvent event) {
		product selected = tblViewProductStock.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStockQuantity(selected.getStockQuantity() + 1);
            tblViewProductStock.refresh();
        }
	}
	
	@FXML private void handleBtnRemoveStock(ActionEvent event) {
		product selected = tblViewProductStock.getSelectionModel().getSelectedItem();
        if (selected != null && selected.getStockQuantity() > 0) {
            selected.setStockQuantity(selected.getStockQuantity() - 1);
            tblViewProductStock.refresh();
        }
	}
	
	@FXML private void handleBtnAddAccount(ActionEvent event) {
		String email = txtFieldAdminPageEmail.getText().trim();
		String username = txtFieldAdminPageUsername.getText().trim();
	    String password = txtFieldAdminPagePassword.getText().trim();
	    
	    if (!email.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
	    	Company.account.addAccount(new Company.account(email, password, username));
	    	System.out.println("New account created: " + email);
	    	
	    	txtFieldAdminPageEmail.clear();
	    	txtFieldAdminPageUsername.clear();
	    	txtFieldAdminPagePassword.clear();
	    }
	}
	
	//IF THERE'S TIME, CREATE FEATURE ADD PRODUCTS
}
