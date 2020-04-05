package com.sanjay.namdeo.cmsspringboot.api;

import com.sanjay.namdeo.cmsspringboot.exception.ApplicationError;
import com.sanjay.namdeo.cmsspringboot.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> handlerCustomerException(CustomerNotFoundException customerException, WebRequest request) {
        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode(100);
        applicationError.setMessage(customerException.getMessage());
        return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
    }
}
