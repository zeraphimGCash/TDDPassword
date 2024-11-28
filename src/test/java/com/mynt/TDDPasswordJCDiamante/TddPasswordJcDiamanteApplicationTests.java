package com.mynt.TDDPasswordJCDiamante;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TddPasswordJcDiamanteApplicationTests {

	private PasswordValidator validator = new PasswordValidator();

	@Nested
	class NegativeTests {

		@Test
		void testPasswordTooShort() {
			ValidationResult result = validator.validate("pass");
			assertFalse(result.isValid());
			assertEquals(4, result.getErrors().size());
			assertTrue(result.getErrors().contains("Password must be at least 8 characters"));
		}

		@Test
		void testPasswordNoNumber() {
			ValidationResult result = validator.validate("Password");
			assertFalse(result.isValid());
			assertTrue(result.getErrors().contains("The password must contain at least 1 number"));
		}

		@Test
		void testPasswordNoUppercase() {
			ValidationResult result = validator.validate("password1!");
			assertFalse(result.isValid());
			assertEquals(1, result.getErrors().size());
			assertTrue(result.getErrors().contains("Password must contain at least one capital letter"));
		}

		@Test
		void testPasswordNoSpecialCharacter() {
			ValidationResult result = validator.validate("Password1");
			assertFalse(result.isValid());
			assertEquals(1, result.getErrors().size());
			assertTrue(result.getErrors().contains("Password must contain at least one special character"));
		}

		@Test
		void testPasswordWithSpaces() {
			ValidationResult result = validator.validate("Password 1!");
			assertFalse(result.isValid());
			assertEquals(1, result.getErrors().size());
			assertTrue(result.getErrors().contains("Password cannot contain spaces"));
		}

		@Test
		void testMultipleErrors() {
			ValidationResult result = validator.validate("pass");
			assertFalse(result.isValid());
			assertEquals(4, result.getErrors().size());
			assertTrue(result.getErrors().contains("Password must be at least 8 characters"));
			assertTrue(result.getErrors().contains("The password must contain at least 1 number"));
			assertTrue(result.getErrors().contains("Password must contain at least one capital letter"));
			assertTrue(result.getErrors().contains("Password must contain at least one special character"));
		}
	}

	@Nested
	class PositiveTests {

		@Test
		void testValidPassword() {
			ValidationResult result = validator.validate("Password1!");
			assertTrue(result.isValid());
			assertEquals(0, result.getErrors().size());
		}
	}
}
