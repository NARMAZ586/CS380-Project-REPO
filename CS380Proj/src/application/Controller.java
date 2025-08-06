package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Controller implements Initializable{

    @FXML private Button btnKeyboards;
    @FXML private MenuButton btnKeycaps;
    @FXML private Button btnSwitches;
    @FXML private Button btnCart;
    @FXML private Button btnAccount;
    @FXML private TextField searchField;
    @FXML private HBox mainImageContainer;
    @FXML private ImageView mainImageView;
    @FXML private HBox secondContainer;
    @FXML private ImageView secondImageView;
    @FXML private HBox thirdContainer;
    @FXML private ImageView thirdImageView;
    @FXML private HBox bottomImageRow;
    @FXML private VBox mainVBox;
    
    
    //buttons
    @FXML
    private void handleCartClick() {
        System.out.println("Cart clicked!");
    }

    @FXML
    private void handleAccountClick() {
        System.out.println("Account clicked!");
    }

    @FXML
    private void handleKeyboardsClick() {
        System.out.println("Keyboards clicked!");
    }

    @FXML
    private void handleKeycapsClick() {
        System.out.println("Keycaps clicked!");
    }

    @FXML
    private void handleSwitchesClick() {
        System.out.println("Switches clicked!");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	mainImageView.fitWidthProperty().bind(mainImageContainer.widthProperty());
    	mainImageView.fitHeightProperty().bind(mainImageContainer.heightProperty());
    	
    	secondImageView.fitWidthProperty().bind(secondContainer.widthProperty());
    	secondImageView.fitHeightProperty().bind(secondContainer.heightProperty());
    	
    	thirdImageView.fitWidthProperty().bind(thirdContainer.widthProperty());
    	thirdImageView.fitHeightProperty().bind(thirdContainer.heightProperty());
    	
    	VBox.setVgrow(mainImageContainer,  Priority.ALWAYS);
    	VBox.setVgrow(bottomImageRow,  Priority.SOMETIMES);
    	HBox.setHgrow(secondContainer, Priority.ALWAYS);
    	HBox.setHgrow(thirdContainer, Priority.ALWAYS);
    	;
    	
    }
    
    private double clamp(double value, double min, double max) {
    	return Math.max(min, Math.min(value,  max));
    }
}