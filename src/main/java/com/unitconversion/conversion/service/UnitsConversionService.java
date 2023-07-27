package com.unitconversion.conversion.service;

import org.apache.commons.jexl3.*;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UnitsConversionService {

    private final JexlEngine jexlEngine;

    public UnitsConversionService() {
        this.jexlEngine = new JexlBuilder().create();
    }

    public Object evaluateExpression(String expression, Map<String, Object> variables){

        JexlExpression jexlexpression = jexlEngine.createExpression(expression);

        JexlContext jexlContext = new MapContext();

        for (Map.Entry<String, Object> entry : variables.entrySet()){
            jexlContext.set(entry.getKey(),entry.getValue());
        }

        return jexlexpression.evaluate(jexlContext);

    }


}
