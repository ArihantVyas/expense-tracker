package com.arihant.expense_tracker.exception;

import com.arihant.expense_tracker.error_response.ErrorResponse_MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse_MethodArgumentNotValidException> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        ErrorResponse_MethodArgumentNotValidException errorResponse = new ErrorResponse_MethodArgumentNotValidException();

        errorResponse.message = exception.getMessage();
        errorResponse.dateTime = LocalDateTime.now();
        errorResponse.status_code = HttpStatus.BAD_REQUEST.value();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
