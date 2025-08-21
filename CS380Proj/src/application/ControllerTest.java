package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Company.account;

class ControllerTest {

    private Controller controller;
    
    @BeforeEach
    void setUp() {
        // Initialize JavaFX environment
        new JFXPanel();

        controller = new Controller() {
            @Override
            public void createScene(ActionEvent event, String fxml) {
                // Do nothing during tests
            }
        };

        // Initialize the UI elements used in checkLogin
        controller.loginEmail = new TextField();
        controller.loginPassword = new PasswordField();
        controller.wrongPasswordLabel = new Label();

        //Constructor is: Email, Password, Username
        account.addAccount(new account("Admin", "123", "Admin"));
    }

    @Test
    void testCorrectLogin() {
        controller.loginEmail.setText("Admin");
        controller.loginPassword.setText("123");

        controller.checkLogin(null); // event can be null for testing

        assertEquals("Success!", controller.wrongPasswordLabel.getText());
    }
    
    @Test
    void testIncorrectLogin() {
        controller.loginEmail.setText("Admin");
        controller.loginPassword.setText("wrongpassword");

        controller.checkLogin(null);

        assertEquals("Wrong email or password! Try again", controller.wrongPasswordLabel.getText());
    }
}
