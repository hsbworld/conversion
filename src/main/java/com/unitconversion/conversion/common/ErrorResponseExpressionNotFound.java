package com.unitconversion.conversion.common;

public class ErrorResponseExpressionNotFound {

    private final String errorCode;

    private final String errorMessage;

    public ErrorResponseExpressionNotFound(String errorCode, String errorMessage) {
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
