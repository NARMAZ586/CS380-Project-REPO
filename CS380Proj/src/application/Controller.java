package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
Controller
Date of code: 8/4/25
The controller class handles the navigation, interations, and logistics for the JavaFX application
This is connected to multiple FXML files such as the Homepage, AdminPage, KeyboardPage, etc. this acts as the main handler for the user interface.
@author Michelle
*/
public class Controller extends SceneController {
    /**
        Returns user to the homepage
    */
    @FXML private Button logoBtn;
    /**
        Entering the login email
    */
    @FXML private TextField loginEmail;
    /**
        Entering the ogin password
    */
    @FXML private PasswordField loginPassword;
    /**
        A label to display a login error message
    */
    @FXML private Label wrongPasswordLabel;
    /**
        Button used to logout the user and return to the homepage
    */
    @FXML private Button logoutBtn;
    /**
        Managing the main application window
    */
    @FXML private Stage stage;
    /**
     * Constructor for the Controller class
     */
    public Controller() {
    }
    /**
        Triggered when the login button is clicked
        @param event ActionEvent button is clicked by the login button 
    */
    @FXML
    public void userLogin(ActionEvent event) {
    	checkLogin(event);
    }
    /**
        Validates user login credentials and displays the feedback and switches to the AdminPage if valid or invalid.
        @param event in ActionEvent is triggered by the login attempt.
    */
    private void checkLogin(ActionEvent event) {
    	String email = loginEmail.getText().trim();
    	String password = loginPassword.getText().trim();
    	
    	if(Company.account.checkCredentials(email, password)) {
    		wrongPasswordLabel.setText("Success!");
    		createScene(event, "AdminPage.fxml");
    		
    	}
    	else if(email.isEmpty() && password.isEmpty()){
    		wrongPasswordLabel.setText("Please enter your data.");
    	}
    	else {
    		wrongPasswordLabel.setText("Wrong email or password! Try again");
    	}
    }
    
    /**
        Logs the user out and returns to the homepage
        @param event is triggered by the logout button
    */
    @FXML
    private void userLogout(ActionEvent event) {
    	createScene(event, "Homepage.fxml");
    }
}