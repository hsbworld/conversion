package com.unitconversion.conversion.common;

public class SuccessResponse {

    private final String inputValue;
    private final String inputUnit;
    private final String outputValue;
    private final String outputUnit;

//    private String conversionDescription;


    public SuccessResponse(String inputValue, String inputUnit, String outputValue, String outputUnit) {
        this.inputValue = inputValue;
        this.inputUnit = inputUnit;
        this.outputValue = outputValue;
        this.outputUnit = outputUnit;
    }

    public String getInputValue() {
        return inputValue;
    }

    public String getInputUnit() {
        return inputUnit;
    }

    public String getOutputValue() {
        return outputValue;
    }

    public String getOutputUnit() {
        return outputUnit;
    }
}
