package com.zemoga.portfolio.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = {UtilsException.class, EntityNotFoundException.class})
    protected ResponseEntity<Map<String, Object>> handleConflict(RuntimeException ex, WebRequest request) {
        Map<String, Object> errorAttributes = new HashMap<>();
        String errorMessage = "The User doesn't exist, please try again";
        errorAttributes.put("status", HttpStatus.CONFLICT);
        errorAttributes.put("message", errorMessage);
        errorAttributes.put("path", request.getAttribute("org.springframework.web.util.UrlPathHelper.PATH", 0));
        return new ResponseEntity<>(errorAttributes, HttpStatus.CONFLICT);
    }
}
