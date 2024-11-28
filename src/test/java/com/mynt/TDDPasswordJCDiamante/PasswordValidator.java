package com.mynt.TDDPasswordJCDiamante;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    public ValidationResult validate(String password) {
        List<String> errors = new ArrayList<>();
        boolean isValid = true;

        // Check password length
        if (password.length() < 8) {
            isValid = false;
            errors.add("Password must be at least 8 characters");
        }

        // Check for at least one numeral
        if (!password.matches(".*\\d.*")) {
            isValid = false;
            errors.add("The password must contain at least 1 number");
        }

        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            isValid = false;
            errors.add("Password must contain at least one capital letter");
        }

        // Check for at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            isValid = false;
            errors.add("Password must contain at least one special character");
        }

        return new ValidationResult(isValid, errors);
    }

}
