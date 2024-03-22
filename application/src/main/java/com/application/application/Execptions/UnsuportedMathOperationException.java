package com.application.application.Execptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

public class UnsuportedMathOperationException extends RuntimeException {

    public UnsuportedMathOperationException(String message) {
        super(message);
    }
}
