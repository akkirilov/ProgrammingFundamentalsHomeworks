package app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
	
	public static Boolean email(String email) {
		String[] tokens = email.split("@");
		if (tokens[0].startsWith(".") || tokens[0].startsWith("_") || tokens[0].startsWith("-")
				|| tokens[0].endsWith(".") || tokens[0].endsWith("_") || tokens[0].endsWith("-")) {
			return false;
		}
		if (!tokens[1].contains(".")) {
			return false;
		}
		if (tokens[1].startsWith(".") || tokens[1].endsWith(".")) {
			return false;
		}
		return true;
	}
	
	public static Boolean passwordSymbols(String password) {
		List<Character> specialCharacters = new ArrayList<>
		(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '<', '>', '?'));
		
		for (int i = 0; i < password.length(); i++) {
			if (specialCharacters.contains(password.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static boolean passwordLength(String password) {
		if (password.length() < 6 || password.length() > 50) {
			return false;
		}
		return true;
	}
	
	public static boolean passwordDigit(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean passwordUppercase(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean passwordLowercase(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	public static Boolean username(String username) {
		if (username.length() < 4 || username.length() > 30) {
			return false;
		}
		return true;
	}
	
	public static Boolean picturePath(String picturePath) {
		if (!picturePath.endsWith(".jpeg") && !picturePath.endsWith(".png")) {
			return false;
		}
		return true;
	}
	
	public static Boolean age(Integer age) {
		if (age < 1 || age > 120) {
			return false;
		}
		return true;
	}

}
