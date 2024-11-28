package com.mynt.TDDPasswordJCDiamante;

import java.util.List;

class ValidationResult {
    private boolean isValid;
    private List<String> errors;

    public ValidationResult(boolean isValid, List<String> errors) {
        this.isValid = isValid;
        this.errors = errors;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<String> getErrors() {
        return errors;
    }
}