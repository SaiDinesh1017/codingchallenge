package com.williamssonoma.codingchallenge.utils;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * API error model is used in response for custom exceptions
 * @author Sai Dinesh Chandaluri
 */
@Getter
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
