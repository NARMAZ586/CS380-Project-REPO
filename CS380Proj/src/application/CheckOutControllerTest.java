package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel; // initializes JavaFX runtime
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

class CheckOutControllerTest {

    private CheckOutController controller;

    @BeforeEach
    void setUp() {
        // Initializes JavaFX runtime (needed for controls)
        new JFXPanel();
        controller = new CheckOutController();

        controller.customerFirstName = new TextField();
        controller.customerLastName = new TextField();
        controller.customerEmail = new TextField();
        controller.customerPhoneNum = new TextField();
        controller.customerAddress = new TextField();
        controller.cardNumber = new TextField();
        controller.cardCVC = new TextField();
        controller.cardExpMonth = new TextField();
        controller.cardExpYear = new TextField();
        controller.paymentProcessResult = new Label();
        controller.validate = new CreditCardValidation();
    }

    @Test
    void testValidPayment() {
        controller.customerFirstName.setText("John");
        controller.customerLastName.setText("Doe");
        controller.customerEmail.setText("john@example.com");
        controller.customerPhoneNum.setText("1234567890");
        controller.customerAddress.setText("123 Main St");
        controller.cardNumber.setText("4929839163636989");
        controller.cardCVC.setText("123");
        controller.cardExpMonth.setText("12");
        controller.cardExpYear.setText("2025");

        controller.VerifyPaymentProcess(new ActionEvent());
        assertEquals("Payment has been processed", controller.paymentProcessResult.getText());
    }

    @Test
    void testBlankFields() {
        controller.customerFirstName.setText("");
        controller.customerLastName.setText("Doe");
        controller.customerEmail.setText("john@example.com");
        controller.customerPhoneNum.setText("1234567890");
        controller.customerAddress.setText("123 Main St");
        controller.cardNumber.setText("4929839163636989");
        controller.cardCVC.setText("123");
        controller.cardExpMonth.setText("12");
        controller.cardExpYear.setText("2025");

        controller.VerifyPaymentProcess(new ActionEvent());
        assertEquals("Fill in all fields", controller.paymentProcessResult.getText());
    }

    @Test
    void testInvalidCard() {
        controller.customerFirstName.setText("John");
        controller.customerLastName.setText("Doe");
        controller.customerEmail.setText("john@example.com");
        controller.customerPhoneNum.setText("1234567890");
        controller.customerAddress.setText("123 Main St");
        controller.cardNumber.setText("123");
        controller.cardCVC.setText("123");
        controller.cardExpMonth.setText("12");
        controller.cardExpYear.setText("2025");

        controller.VerifyPaymentProcess(new ActionEvent());
        assertEquals("Card information is invalid", controller.paymentProcessResult.getText());
    }
}
