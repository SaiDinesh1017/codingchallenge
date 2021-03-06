package com.williamssonoma.codingchallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom Exception
 * @author Sai Dinesh Chandaluri
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidZipCodeRangeException extends Exception {
    public InvalidZipCodeRangeException(String message) {
        super(message);
    }
}
