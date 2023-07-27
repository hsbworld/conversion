package com.unitconversion.conversion.common;

import com.unitconversion.conversion.customexceptions.NotANumberException;

public class Validations {

    public static void validateInput (Object value){

        try{
            Double.parseDouble((String) value);
        }
        catch (NumberFormatException ex) {
            throw new NotANumberException("Invalid unit value: " + value);
        }

    }

}
