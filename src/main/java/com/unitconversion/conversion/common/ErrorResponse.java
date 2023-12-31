package com.unitconversion.conversion.common;

public class ErrorResponse {

    private final String errorCode;

    private final String errorMessage;

    private final String inputUnit;

    private final String outputUnit;

    public ErrorResponse(String errorCode, String errorMessage, String inputUnit, String outputUnit) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.inputUnit = inputUnit;
        this.outputUnit = outputUnit;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getInputUnit() {
        return inputUnit;
    }

    public String getOutputUnit() {
        return outputUnit;
    }
}
