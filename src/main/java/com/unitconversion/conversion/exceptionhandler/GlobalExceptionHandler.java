package com.unitconversion.conversion.exceptionhandler;

import com.unitconversion.conversion.common.ErrorResponse;
import com.unitconversion.conversion.customexceptions.ExpressionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExpressionNotFoundException.class)
    public ResponseEntity<Object> handleExpressionNotFoundException(ExpressionNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
