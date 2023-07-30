package com.unitconversion.conversion.service;

import com.unitconversion.conversion.controller.controller;
import com.unitconversion.conversion.entities.Expressions;
import com.unitconversion.conversion.interfaces.ExpressionsRepository;
import com.unitconversion.conversion.common.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExpressionsService {

    private final ExpressionsRepository expressionsRepository;
    private final UnitsConversionService unitsConversionService;

    private static final Logger logger = LoggerFactory.getLogger(controller.class);

    @Autowired
    public ExpressionsService(ExpressionsRepository expressionsRepository, UnitsConversionService unitsConversionService) {
        this.expressionsRepository = expressionsRepository;
        this.unitsConversionService = unitsConversionService;
    }

    public Expressions getExpression(String conversionType) {
        return expressionsRepository.findById(conversionType).orElse(null);
    }

    public SuccessResponse performConversion(Expressions expression, Object value){

//      Expressions expression;
        String formula;
        Map<String, Object> variable = new HashMap<>();

        formula = expression.getFormula();
        variable.put("input", value);

        Object result = unitsConversionService.evaluateExpression(formula, variable);
        logger.info("Converted from {} to {}", value, result);

        return new SuccessResponse(value.toString(), expression.getInputUnit(), result.toString(), expression.getOutputUnit());

    }

}
