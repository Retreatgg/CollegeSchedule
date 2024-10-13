package com.example.collegeschedule.exception.handler;

import com.example.collegeschedule.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppError> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, errorMessage);
        });

        AppError appError = new AppError(
                HttpStatus.BAD_REQUEST.value(),
                "Ошибка валидации",
                validationErrors
        );
        return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AudienceNotFoundException.class)
    public ResponseEntity<AppError> handlerAudienceNotFound(AudienceNotFoundException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AudienceTypeNotFoundException.class)
    public ResponseEntity<AppError> handlerAudienceTypeNotFound(AudienceTypeNotFoundException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DisciplineNotFoundException.class)
    public ResponseEntity<AppError> handlerDisciplineNotFound(DisciplineNotFoundException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<AppError> handlerGroupNotFound(GroupNotFoundException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<AppError> handlerTeacherNotFound(TeacherNotFoundException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RelatedEntityConstraintException.class)
    public ResponseEntity<AppError> handlerRelatedException(RelatedEntityConstraintException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
