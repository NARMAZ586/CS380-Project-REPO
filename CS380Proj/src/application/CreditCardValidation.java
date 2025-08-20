package application;
/**
  CreditCardValidation
  Date of code: 8/12/25
  When making a purchase users have the option of paying with a credit card
  Important methods: isValidCard(String Card, String CVC, String expMonth, String expYear), checkSum(String num), isNumeric(String num)
  For checkSum, it was built on the Luhn algorithm, this is a popular algorithm used to verify if a card number is valid.
  It works for many different card types like Visa, MasterCard, etc and it was chosen for how efficient and effective it is
  @author Nery Armaz
 */
public class CreditCardValidation {
	/**
	 * default constructor of CreditCardvalidation
	 */
	public CreditCardValidation() {}
	/**
	 static main method that was used to test this program on its on
	 @param args starts the args of CreditCard
	 */
	public static void main(String[] args) {
		Boolean result = isValidCard("4929839163636989", "123", "11", "2027");
		System.out.println(result);
    }
	
	/**
	 * This method combines all methods below to determine if all card inputs are valid and therefore the whole card is valid 
	 * @param Card user inputs their card number
	 * @param CVC this is for the security code of the card
	 * @param expMonth this for the expiration month
	 * @param expYear this is for the expiration year
	 * @return The return of this method is either true or false, so either the card is valid or invalid
	 */
	//card must be between length 14-16 and all characters must be numeric
	public static Boolean isValidCard(String Card, String CVC, String expMonth, String expYear) {
		if (Card == null ||Card.length() < 14 || Card.length() > 16 || !isNumeric(Card)) {
			return false;
		}
		if (CVC == null || !isNumeric(CVC)) {
			return false;
		}
		if (expMonth == null || expYear == null || !isNumeric(expMonth) || !isNumeric(expYear)) {
			return false;
		}
		//System.out.println("all inputs for card info are numeric");
		if (checkSum(Card) && isValidCVC(CVC) && isValidExpiration(expMonth, expYear)){
			System.out.println("Passed all card verification tests: valid");
			return true;
		} else {
			System.out.println("Did not pass all card verification tests: invalid");
			return false;
		}
	}
	/**
	 * Takes the card number that was inputed into isValidCard, and uses the Luhn algorithm to determine if it is valid
	 * @param num, this is the same parameter as Card from isValidCard
	 * @return The return is boolean, so it is either true or false
	 */
	//Uses Luhn Algorithm to verify if Card number is valid
	public static Boolean checkSum(String num) {
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
				//System.out.println(currNum);
				sum += currNum;
			} else {
				//System.out.println(Character.getNumericValue(num.charAt(i)));
				sum += Character.getNumericValue(num.charAt(i));
			}
			//System.out.println(alternate);
			alternate = !alternate;
			
		}
		//System.out.println(sum);
		int result = sum * 9;
		if (result % 10 == 0) {
			//System.out.println("Valid card number");
			return true;
		} else {
			//System.out.println("Invalid card");
			return false;
		}
	}
	
	/**
	 * Takes input for CVC and checks if length is correct and if all characters are numeric
	 * @param num number of the CVC for the card
	 * @return only returns true or false since it is Boolean
	 */
	//Checks length of CVC and if it's all numeric
	private static Boolean isValidCVC(String num) {
		if (!isNumeric(num) || num.length() < 3 || num.length() > 4) {
			//System.out.println("invalid CVC");
			return false;
		}
		//System.out.println("valid CVC");
		return true;	
	}
	/**
	 * Method will check if the expiration dates for month and year are valid
	 * It checks if year is within next 5 years and that year is not less than 2025
	 * Also checks that month is between 1 and 12
	 * @param m The expiration month for the card
	 * @param y The expiration year for the card
	 * @return The return is either true or false
	 */
	//checks if expiration is valid
	private static Boolean isValidExpiration(String m, String y) {
		int month = Integer.parseInt(m);
		int year = Integer.parseInt(y);
		if (month < 1 || month > 12 || year < 2025 || year > 2030) {
			//System.out.println("invalid month or year");
			return false;
		}
		//System.out.println("valid month and year");
		return true;
	}
	/**
	 * Method checks if a string is composed of only numeric values like digits 0 - 9
	 * Method is used for every single input of the card information
	 * @param num Any string of the card information(Used on card number, cvc, and expiration)
	 * @return True if string is composed of only numeric values and false anything else
	 */
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
