package com.unitconversion.conversion.customexceptions;

public class ExpressionNotFoundException extends RuntimeException{

    private final String errorCode;

    private final String errorMessage;

    public ExpressionNotFoundException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
