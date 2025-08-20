package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CreditCardValidationTest {


	@Test
	void testIsValidCardValidInputs() {
		boolean result = CreditCardValidation.isValidCard("4929839163636989", "123", "12", "2025");
        assertTrue(result, "Card should be valid with correct inputs");
	}
	
	@Test
	void testIsValidCardInvalidInputs() {
		boolean result = CreditCardValidation.isValidCard("123", "12345", "0", "2020");
		assertFalse(result, "Card should be invalid with incorrect inputs");
	}
	
	@Test
	void testIsValidCardEmptyString() {
		boolean result = CreditCardValidation.isValidCard("", "", "", "");
		assertFalse(result, "Card should be invalid with empty inputs");
	}
	@Test
	void testCheckSumInvalidInputs() {
		boolean result = CreditCardValidation.checkSum("1234");
		assertFalse(result, "Card number should be invalid with incorrect input");
	}
	
	@Test
	void testChechSumValidInputs() {
		boolean result = CreditCardValidation.checkSum("4929839163636989");
		assertTrue(result, "Card number should be valid with correct input");
	}
	
	@Test
	void testChechSumEmptyString() {
		boolean result = CreditCardValidation.checkSum("");
		assertTrue(result, "Card number should be invalid with empty string");
	}

}
