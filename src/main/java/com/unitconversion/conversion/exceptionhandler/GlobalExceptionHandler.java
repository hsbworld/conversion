package com.unitconversion.conversion.exceptionhandler;

import com.unitconversion.conversion.common.ErrorResponse;
import com.unitconversion.conversion.common.ErrorResponseExpressionNotFound;
import com.unitconversion.conversion.common.Validations;
import com.unitconversion.conversion.customexceptions.ExpressionNotFoundException;
import com.unitconversion.conversion.customexceptions.InvalidValueException;
import com.unitconversion.conversion.customexceptions.NotANumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(Validations.class);

    @ExceptionHandler(ExpressionNotFoundException.class)
    public ResponseEntity<Object> handleExpressionNotFoundException(ExpressionNotFoundException ex){
        logger.error("An error occurred:", ex);
        ErrorResponseExpressionNotFound errorResponse = new ErrorResponseExpressionNotFound(ex.getErrorCode(), ex.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotANumberException.class)
    public ResponseEntity<ErrorResponse> handleNotANumberException(NotANumberException ex) {

        logger.error("An error occurred:", ex);
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage(), ex.getInputUnit(), ex.getOutputUnit());
//        ErrorResponse errorResponse = new ErrorResponse("", "");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<Object> handleInvalidValueException(InvalidValueException ex) {
        logger.error("An error occurred:", ex);
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage(), ex.getInputUnit(), ex.getOutputUnit());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
