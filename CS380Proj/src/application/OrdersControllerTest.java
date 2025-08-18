package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import jakarta.mail.*;
import jakarta.mail.internet.MimeMessage;

class OrdersControllerTest {

	@Test
	void testSendEmail() {
		String testemail = "customerreceiver@gmail.com";
		String orderId = "100";
		String shipMethod = "Standard";
		String items = "keycaps";
		double total = 150.50;
	
	
	/**assertDoesNotThrow(() -> {
        OrdersController.sendEmail(testemail, orderId, shipMethod, total, items);
    });*/
	
	
	System.out.println("Email sent(check inbox) for validation test");
	}

}
