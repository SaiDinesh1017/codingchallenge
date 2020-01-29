package com.williamssonoma.codingchallenge.validator;

import com.williamssonoma.codingchallenge.domain.ZipCode;
import com.williamssonoma.codingchallenge.exception.InvalidZipCodeRangeException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Validates that upper bound of single zip code range must be greater than the lower bound
 * @author Sai Dinesh Chandaluri
 */
@Component
public class ZipRangeValidator {
    public void validateZipCodeRanges(List<ZipCode> zipCodeList) throws InvalidZipCodeRangeException {
        if(zipCodeList.stream().anyMatch(zipCode -> zipCode.getLowerBound() > zipCode.getUpperBound())) {
            throw new InvalidZipCodeRangeException("Zip code range is invalid - The lower bound is greater than upper bound");
        }
    }
}
