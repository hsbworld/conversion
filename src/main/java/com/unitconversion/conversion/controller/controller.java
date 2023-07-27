package com.unitconversion.conversion.controller;

import com.unitconversion.conversion.common.SuccessResponse;
import com.unitconversion.conversion.common.Validations;
import com.unitconversion.conversion.customexceptions.ExpressionNotFoundException;
import com.unitconversion.conversion.entities.Expressions;
import com.unitconversion.conversion.service.ExpressionsService;
import com.unitconversion.conversion.service.UnitsConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("api")
public class controller {

    private final UnitsConversionService unitsConversionService;

    private final ExpressionsService expressionsService;

    @Autowired
    public controller(UnitsConversionService unitsConversionService, ExpressionsService expressionsService) {
        this.unitsConversionService = unitsConversionService;
        this.expressionsService = expressionsService;
    }

    @GetMapping("convert/{conversionType}/{value}")
    public ResponseEntity<Object> convert(@PathVariable String conversionType, @PathVariable Object value){

        Expressions expression;
        String formula;
        Map<String, Object> variable = new HashMap<>();

        Validations.validateInput(value);

        expression = expressionsService.getExpression(conversionType);

        if (expression == null){
            throw new ExpressionNotFoundException("Expression with conversion type " + conversionType + " not found");
        }

        formula = expression.getExpression();
        variable.put("input", value);

        Object result = unitsConversionService.evaluateExpression(formula, variable);
        SuccessResponse response = new SuccessResponse(result.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
