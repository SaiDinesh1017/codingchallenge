package com.williamssonoma.codingchallenge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Model for zip code range
 * @author Sai Dinesh Chandaluri
 */
@Getter
@Setter
public class ZipCode {
    @Min(value = 10000, message = "Zip Code should not be less than 5 digit code(Ex:10000)")
    @Max(value = 99999, message = "Zip Code should not be greater than 5 digit code(Ex:10000)")
    private Integer lowerBound;

    @Min(value = 10000, message = "Zip Code should not be less than 5 digit code(Ex:10000)")
    @Max(value = 99999, message = "Zip Code should not be greater than 5 digit code(Ex:10000)")
    private Integer upperBound;
}
