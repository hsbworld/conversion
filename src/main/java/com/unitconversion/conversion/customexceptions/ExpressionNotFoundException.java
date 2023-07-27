package com.unitconversion.conversion.customexceptions;

public class ExpressionNotFoundException extends RuntimeException{
    public ExpressionNotFoundException(String message) {
        super(message);
    }
}
