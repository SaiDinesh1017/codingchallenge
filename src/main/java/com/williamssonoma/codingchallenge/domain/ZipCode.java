package com.williamssonoma.codingchallenge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class ZipCode {
    @Min(value = 10000, message = "Zip Code should not be less 5 digit code(10000)")
    @Max(value = 99999, message = "Zip Code should not be greater than 5 digit code(10000)")
    private Integer lowerBound;

    @Min(value = 10000, message = "Zip Code should not be less 5 digit code(10000)")
    @Max(value = 99999, message = "Zip Code should not be greater than 5 digit code(10000)")
    private Integer upperBound;
}
