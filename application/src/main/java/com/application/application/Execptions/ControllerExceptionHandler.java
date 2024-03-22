package com.application.application.Execptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = UnsuportedMathOperationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> resourceNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse message = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}