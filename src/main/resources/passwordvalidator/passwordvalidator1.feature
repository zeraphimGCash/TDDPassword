Feature: Password Validator
  As a user
  I want to validate passwords
  So that only secure passwords are accepted

  Scenario: Password is too short
    Given I have a password "short"
    When I validate the password
    Then the result should be invalid
    And the errors should contain "Password must be at least 8 characters"

  Scenario: Password does not contain a number
    Given I have a password "Password"
    When I validate the password
    Then the result should be invalid
    And the errors should contain "The password must contain at least 1 number"

  Scenario: Password does not contain an uppercase letter
    Given I have a password "password1!"
    When I validate the password
    Then the result should be invalid
    And the errors should contain "Password must contain at least one capital letter"

  Scenario: Password does not contain a special character
    Given I have a password "Password1"
    When I validate the password
    Then the result should be invalid
    And the errors should contain "Password must contain at least one special character"

  Scenario: Password contains spaces
    Given I have a password "Password 1!"
    When I validate the password
    Then the result should be invalid
    And the errors should contain "Password cannot contain spaces"

  Scenario: Password is valid
    Given I have a password "Password1!"
    When I validate the password
    Then the result should be valid
    And the errors should be empty
