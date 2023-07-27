package com.unitconversion.conversion.controller;

import com.unitconversion.conversion.common.ErrorResponse;
import com.unitconversion.conversion.common.SuccessResponse;
import com.unitconversion.conversion.customexceptions.ExpressionNotFoundException;
import com.unitconversion.conversion.entities.Expressions;
import com.unitconversion.conversion.service.ExpressionsService;
import com.unitconversion.conversion.service.UnitsConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("api")
public class controller {

    private final UnitsConversionService unitsConversionService;
//    @Autowired
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

        expression = expressionsService.getExpression(conversionType);

        if (expression == null){
            ErrorResponse errorResponse = new ErrorResponse("Expression with conversion type " + conversionType + " not found");
            throw new ExpressionNotFoundException("Expression with conversion type " + conversionType + " not found");
//            return new ResponseEntity<>(errorResponse);
//            throw new ExpressionNotFoundException("Expression with conversion type " + conversionType + " not found");
        }

        formula = expression.getExpression();
        variable.put("input", value);
        Object result = unitsConversionService.evaluateExpression(formula, variable);
        System.out.println("1234");
        SuccessResponse response = new SuccessResponse(result.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
//        return result;

    }

//    public String convert(@PathVariable String conversionType, @PathVariable BigDecimal value){
////        Double result;
//        BigDecimal result;
////        result = value * 9.0 / 5.0 + 32;
//        result = value.multiply( new BigDecimal("9")
//                    .divide(new BigDecimal(5)) )
//                    .add(new BigDecimal("32"));
//        return "Converted value: " + result;
//    }

    @GetMapping("evaluate")
    public String evaluateExpression(@RequestParam String expression) {

        Map<String, Object> variables = new HashMap<>();

        variables.put("x", 10);
        variables.put("y", 5);

        System.out.println("Before evaluate..." + variables + expression);
        Object result = unitsConversionService.evaluateExpression(expression, variables);

        return "Result: " + result;

    }

    @GetMapping("convert2/{conversionType}/{value}")
    public String performConversion(@PathVariable String conversionType, @PathVariable String value){

        Map<String, Object> variables = new HashMap<>();

        String expression;

//        expression = "value * 9.0 / 5.0 + 32";
        expression = "value * 1000";

        variables.put("value", value);

        Object result = unitsConversionService.evaluateExpression(expression, variables);

        return "Result: " + result;

    }

    @GetMapping("expressions/{conversionType}")
    public Expressions findExpression(@PathVariable String conversionType){
        System.out.println(conversionType);
        System.out.println(expressionsService.getExpression(conversionType).toString());
        return expressionsService.getExpression(conversionType);
    }

}
