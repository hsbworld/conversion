package com.unitconversion.conversion.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Expressions {
    @Id
    private String conversionType;
    private String formula;
    private Double minimumValueAllowed;
    private Double maximumValueAllowed;
    private String conversionDescription;
    private String inputUnit;
    private String outputUnit;
    public String getFormula() {
        return formula;
    }
    public Double getMinimumValueAllowed() {
        return minimumValueAllowed;
    }
    public Double getMaximumValueAllowed() {
        return maximumValueAllowed;
    }
    public String getInputUnit() {
        return inputUnit;
    }
    public String getOutputUnit() {
        return outputUnit;
    }

    @Override
    public String toString() {
        return "Expressions{" +
                "conversionType='" + conversionType + '\'' +
                ", formula='" + formula + '\'' +
                ", minimumValueAllowed=" + minimumValueAllowed +
                ", maximumValueAllowed=" + maximumValueAllowed +
                ", conversionDescription='" + conversionDescription + '\'' +
                ", inputUnit='" + inputUnit + '\'' +
                ", outputUnit='" + outputUnit + '\'' +
                '}';
    }
}
