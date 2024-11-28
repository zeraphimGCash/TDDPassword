package com.mynt.TDDPasswordJCDiamante;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    public ValidationResult validate(String password) {
        List<String> errors = new ArrayList<>();

        // Check password length
        if (password.length() < 8) {
            errors.add("Password must be at least 8 characters");
        }

        // Check for at least one number
        if (!password.matches(".*\\d.*")) {
            errors.add("The password must contain at least 1 number");
        }

        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            errors.add("Password must contain at least one capital letter");
        }

        // Check for at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            errors.add("Password must contain at least one special character");
        }

        // Return validation result
        return new ValidationResult(errors.isEmpty(), errors);
    }
}