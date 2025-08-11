package com.workintech.s18d2.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class VegetableException extends RuntimeException{
    private HttpStatus httpStatus;

    public VegetableException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
