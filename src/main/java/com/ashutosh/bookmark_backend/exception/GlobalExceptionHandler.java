package com.ashutosh.bookmark_backend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentValidationException(MethodArgumentNotValidException exception) {
        List<ValidationFailureField> list = exception.getFieldErrors()
                .stream().map(fe -> new ValidationFailureField(fe.getField(), fe.getDefaultMessage())).toList();
        return ResponseEntity.badRequest().body(new ValidationFailureResponse("Invalid request object.", list));
    }
}
