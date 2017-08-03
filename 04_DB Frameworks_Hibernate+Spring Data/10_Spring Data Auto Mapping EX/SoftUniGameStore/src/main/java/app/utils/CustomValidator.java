package app.utils;

public class CustomValidator {
	
	public static Boolean vaidatePassword(String password){
		
		boolean containsLowerLetter = false;
		boolean containsUpperLetter = false;
		boolean containsDigit = false;
		
		for (int i = 0; i < password.length(); i++) {
		    
			if (Character.isLowerCase(password.charAt(i))) {
				containsLowerLetter = true;
			} else if (Character.isUpperCase(password.charAt(i))) {
				containsUpperLetter = true;
			} else if (Character.isDigit(password.charAt(i))) {
				containsDigit = true;
			}
			
			if (containsLowerLetter && containsUpperLetter && containsDigit) {
				return true;
			}
			
		}
		
		return false;
	}

	public static String validateSize(String param) {
		if (!param.contains(".")) {
			return "Size must be floating point number!";
		}
		if (param.split("\\.")[1].length() != 1) {
			return "Size must be with precision up to 1 digit after floating point!";
		}
		Double result = 0.00;
		try {
			result = Double.parseDouble(param);
			if (result < 0.00) {
				return "Size must be positeve number!";
			}
		} catch (Exception e) {
			return "Invalid size format!";
		}
		return null;
	}

}
