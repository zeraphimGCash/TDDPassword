package com.mynt.TDDPasswordJCDiamante;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TddPasswordJcDiamanteApplication {

	public static void main(String[] args) {
		PasswordValidator validator = new PasswordValidator();

		// Test cases to check password validation
		String[] testPasswords = {
				"pass",          // Too short
				"Password",      // No number
				"password1!",    // No uppercase
				"Password1",     // No special character
				"Password 1!",    // With Whitespace
				"Password1!"     // Valid password
		};

		for (String password : testPasswords) {
			ValidationResult result = validator.validate(password);
			System.out.println("Testing password: " + password);
			System.out.println("Valid: " + result.isValid());
			System.out.println("Errors: " + result.getErrors());
			System.out.println();
		}
	}

}