Feature: Password Validator
  As a user
  I want to validate passwords with multiple validation errors
  So that these validation errors can be listed

  Scenario: Password fails multiple validation rules
    Given I have a password "somebs"
    When I validate the password
    Then the result should be invalid
    And the errors should contain "Password must be at least 8 characters"
    And the errors should contain "The password must contain at least 1 number"
