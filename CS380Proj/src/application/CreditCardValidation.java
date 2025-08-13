package application;

public class CreditCardValidation {
	public static void main(String[] args) {
		Boolean result = isValidCard("4532566939013388", "123", "12", "2030");
		System.out.println(result);
    }
	//card must be between length 14-16 and all characters must be numeric
	public static Boolean isValidCard(String Card, String CVC, String expMonth, String expYear) {
		if (Card.length() < 14 || Card.length() > 16 || Card == null || !isNumeric(Card)) {
			return false;
		}
		if (CVC == null || !isNumeric(CVC)) {
			return false;
		}
		if (expMonth == null || !isNumeric(expMonth) || expYear == null || !isNumeric(expYear)) {
			return false;
		}
		System.out.println("all inputs for card info are numeric");
		if (checkSum(Card) && isValidCVC(CVC) && isValidExpiration(expMonth, expYear)){
			System.out.println("Passed all card tests: valid");
			return true;
		} else {
			System.out.println("Did not pass all card tests: invalid");
			return false;
		}
	}
	
	//Uses Luhn Algorithm to verify if Card number is valid
	private static Boolean checkSum(String num) {
		Boolean alternate = false;
		int currNum = 0;
		int sum = 0;
		for(int i = num.length() - 1; i >= 0; --i) {
			//System.out.println(i);
			if (alternate) {
				currNum = Character.getNumericValue(num.charAt(i)) * 2;
				if (currNum > 9) {
					currNum = currNum - 9;
				}
				System.out.println(currNum);
				sum += currNum;
			} else {
				System.out.println(Character.getNumericValue(num.charAt(i)));
				sum += Character.getNumericValue(num.charAt(i));
			}
			//System.out.println(alternate);
			alternate = !alternate;
			
		}
		System.out.println(sum);
		int result = sum * 9;
		if (result % 10 == 0) {
			System.out.println("Valid card number");
			return true;
		} else {
			System.out.println("Invalid card");
			return false;
		}
	}
	
	//Checks length of CVC and if it's all numeric
	private static Boolean isValidCVC(String num) {
		if (!isNumeric(num) || num.length() < 3 || num.length() > 4) {
			System.out.println("invalid CVC");
			return false;
		}
		System.out.println("valid CVC");
		return true;	
	}
	
	//checks if expiration is valid
	private static Boolean isValidExpiration(String m, String y) {
		int month = Integer.parseInt(m);
		int year = Integer.parseInt(y);
		if (month < 1 || month > 12 || year < 2025 || year > 2030) {
			System.out.println("invalid month or year");
			return false;
		}
		System.out.println("valid month and year");
		return true;
	}
	
	//Looks through entire string to check if every character is a digit between 0 -9
	private static Boolean isNumeric(String num) {
		for (int i = 0; i < num.length(); i ++) {
			if (!Character.isDigit(num.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
