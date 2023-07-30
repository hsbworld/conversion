package com.unitconversion.conversion.common;

import com.unitconversion.conversion.customexceptions.ExpressionNotFoundException;
import com.unitconversion.conversion.customexceptions.InvalidValueException;
import com.unitconversion.conversion.customexceptions.NotANumberException;
import com.unitconversion.conversion.entities.Expressions;

public class Validations {

    public static void validateInput (Object value, Expressions expressions, String conversionType){

        double inputValue;

//      Validate if the expression type is valid (present in H2 DB)
        if (expressions == null){
            throw new ExpressionNotFoundException("EXPRESSION_NOT_FOUND", "Expression with conversion type " + conversionType + " not found");
        }

//      Validate if the input is numeric
        try{
            inputValue = Double.parseDouble((String) value);
        }
        catch (NumberFormatException ex) {
            throw new NotANumberException("INVALID_VALUE", "Invalid unit value: " + value, expressions.getInputUnit(), expressions.getOutputUnit());
        }

//      Validate minimum value
        if ( inputValue < expressions.getMinimumValueAllowed() && expressions.getMinimumValueAllowed() != 0 ) {

            throw new InvalidValueException("INVALID_VALUE", "For " + expressions.getInputUnit() + " to " + expressions.getOutputUnit() + " conversion, the value should be above " + expressions.getMinimumValueAllowed().toString() + ".",
                                                expressions.getInputUnit(), expressions.getOutputUnit());
        }

//      Validate maximum value
        if ( inputValue > expressions.getMaximumValueAllowed() && expressions.getMaximumValueAllowed() != 0) {

            throw new InvalidValueException("INVALID_VALUE", "For " + expressions.getInputUnit() + " to " + expressions.getOutputUnit() + " conversion, the value should be below " + expressions.getMaximumValueAllowed().toString() + ".",
                                                expressions.getInputUnit(), expressions.getOutputUnit());
        }

    }

}
