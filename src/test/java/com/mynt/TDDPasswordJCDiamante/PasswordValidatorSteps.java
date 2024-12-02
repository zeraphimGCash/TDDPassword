package com.mynt.TDDPasswordJCDiamante;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import java.util.List;

public class PasswordValidatorSteps {

    private PasswordValidator validator;
    private ValidationResult result;
    private String password;

    @Given("I have a password {string}")
    public void i_have_a_password(String password) {
        validator = new PasswordValidator();
        this.password = password;
    }

    @When("I validate the password")
    public void i_validate_the_password() {
        result = validator.validate(password);
    }

    @Then("the result should be valid")
    public void the_result_should_be_valid() {
        assertTrue("Expected password to be valid, but it was invalid", result.isValid());
    }

    @Then("the result should be invalid")
    public void the_result_should_be_invalid() {
        assertFalse("Expected password to be invalid, but it was valid", result.isValid());
    }

    @Then("the errors should contain {string}")
    public void the_errors_should_contain(String expectedError) {
        List<String> errors = result.getErrors();
        assertTrue("Expected error message to be present: " + expectedError, errors.contains(expectedError));
    }

    @Then("the errors should be empty")
    public void the_errors_should_be_empty() {
        assertTrue("Expected no errors, but some errors were present", result.getErrors().isEmpty());
    }
}
