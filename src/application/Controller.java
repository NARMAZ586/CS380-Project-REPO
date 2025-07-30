package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class Controller {

    @FXML private Button btnKeyboards;
    @FXML private MenuButton btnKeycaps;
    @FXML private Button btnSwitches;
    @FXML private Button btnCart;
    @FXML private Button btnAccount;
    @FXML private TextField searchField;

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
}
