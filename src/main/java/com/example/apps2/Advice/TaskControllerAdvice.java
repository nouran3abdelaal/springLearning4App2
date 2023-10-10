package com.example.apps2.Advice;

import com.example.apps2.Exceptions.customException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskControllerAdvice {
    @ExceptionHandler(customException.class)
    public ResponseEntity deleteEmployee(customException customException){
        return ResponseEntity.noContent().build();

    }
}
