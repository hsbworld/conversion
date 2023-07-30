package com.unitconversion.conversion.customexceptions;

public class NotANumberException extends RuntimeException {

    private final String errorCode;

    private final String errorMessage;

    private final String inputUnit;

    private final String outputUnit;

    public NotANumberException(String errorCode, String errorMessage, String inputUnit, String outputUnit) {
        super(errorMessage);
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
