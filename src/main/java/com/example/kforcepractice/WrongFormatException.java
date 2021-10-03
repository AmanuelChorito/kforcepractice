package com.example.kforcepractice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongFormatException extends RuntimeException{
    public WrongFormatException() {
        super();
    }

}
