package com.unitconversion.conversion.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Expressions {

    @Id
    @Column(name="CONVERSION_TYPE")
    private String conversionType;

    private String expression;

    public String getConversionType() {
        return conversionType;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "Expressions{" +
                "conversionType='" + conversionType + '\'' +
                ", expression='" + expression + '\'' +
                '}';
    }
}
