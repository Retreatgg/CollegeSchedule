package com.example.collegeschedule.exception;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class AppError {
    private int status;
    private String message;
    private Date timestamp;
    private Map<String, String> error;

    public AppError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }

    public AppError(int status, String message, Map<String, String> errors) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
        this.error = errors;
    }
}
