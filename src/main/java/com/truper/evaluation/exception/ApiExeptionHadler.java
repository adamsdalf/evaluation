package com.truper.evaluation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ApiExeptionHadler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<String> detail = ex.getFieldErrors().stream().map(fieldError -> fieldError.getField() +":"+ fieldError.getDefaultMessage()).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of("details",  String.join("; ", detail)  ,
                        "status", HttpStatus.BAD_REQUEST.name(),
                        "codeError", HttpStatus.BAD_REQUEST.value())
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(NotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            Map.of("details",  ex.getMessage() ,
                    "status", HttpStatus.NOT_FOUND.name(),
                    "codeError", HttpStatus.NOT_FOUND.value())
    );
    }
}
