package com.grib.mobile.app.ws.exceptions;

import com.grib.mobile.app.ws.ui.model.responce.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice//to mark this class listen the application we mark it with this annotation
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    //here we mark which class of exceptions will be handled
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception exception, WebRequest request) {
        String errorMessageDescription = exception.getLocalizedMessage();

        //check for NullPointerException
        if (errorMessageDescription == null) {
            errorMessageDescription = exception.toString();
        }

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
