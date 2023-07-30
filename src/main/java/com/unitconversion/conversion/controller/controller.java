package com.unitconversion.conversion.controller;

import com.unitconversion.conversion.common.SuccessResponse;
import com.unitconversion.conversion.common.Validations;
import com.unitconversion.conversion.entities.Expressions;
import com.unitconversion.conversion.service.ExpressionsService;
import com.unitconversion.conversion.service.UnitsConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(controller.class);

    @Autowired
    public controller(UnitsConversionService unitsConversionService, ExpressionsService expressionsService) {
        this.unitsConversionService = unitsConversionService;
        this.expressionsService = expressionsService;
    }

    @GetMapping("convert/{conversionType}/{value}")
    public ResponseEntity<Object> convert(@PathVariable String conversionType, @PathVariable Object value){

        Expressions expression;
        SuccessResponse response;

        logger.debug("Entering convert method with value={}", value);

//      Get expression from H2 DB
        expression = expressionsService.getExpression(conversionType.toUpperCase());

        Validations.validateInput(value, expression, conversionType);

        response = expressionsService.performConversion(expression, value);
        logger.debug("Exiting convertToCelsius method with result={}", response.getOutputValue());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
