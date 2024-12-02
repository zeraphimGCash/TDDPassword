# TDDPassword

Instructions:
Create a class that serves as a password validator. The validation takes a string as an input and returns a validation result. The validation result should contain a boolean indicating if the password is valid or not, and also a list of the possible validation errors.

**Requirements**
1. The password must be at least & characters long. If it is not met, then the following error message should be returned: "Password must be at least 8 characters"
2. The password must contain at least 1 numeral. If it is not met, then the following error message should be returned: "The password must contain at least 1 number"
3. The validation function should handle multiple validation errors.
   For example, "somepassword" should an error message: "Password must be at least 8 characters, The password must contain at least 1 number"
4. The password must contain at least one uppercase letter. If it is not met, then the following error message should be returned: "password must contain at least one capital letter"
5. The password must contain at least one special character. If it is not met, then the following error message should be returned: "password must contain at least one special character"

`NOTE: Use TDD`

## Password Validation
![Password Validation](Assets/PassValidation.png)

## Test Cases
![Test Cases](Assets/TestCases.png)

## Nested Test Cases
```java

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


```

## Cucumber Tests Output

![Cucumber Report 1](Assets/cucumber_report1.png)

![Cucumber Report 2](Assets/cucumber_report2.png)
