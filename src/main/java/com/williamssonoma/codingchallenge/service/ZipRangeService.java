package com.williamssonoma.codingchallenge.service;

import com.williamssonoma.codingchallenge.comparator.ZipRangeComparator;
import com.williamssonoma.codingchallenge.domain.ZipCode;
import com.williamssonoma.codingchallenge.exception.InvalidZipCodeRangeException;
import com.williamssonoma.codingchallenge.validator.ZipRangeValidator;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.max;

/**
 * Zip service produces the minimum number of ranges required to represent the same sets of ranges
 * obtained from multiple sources.
 * @author Sai Dinesh Chandaluri
 */
@Service
public class ZipRangeService {

    private final ZipRangeComparator zipRangeComparator;

    private final ZipRangeValidator zipRangeValidator;

    public ZipRangeService(ZipRangeComparator zipRangeComparator, ZipRangeValidator zipRangeValidator) {
        this.zipRangeComparator = zipRangeComparator;
        this.zipRangeValidator = zipRangeValidator;
    }

    /**
     * This method compares the upper bound of previous zip code range object with lower bound of current zip code range
     * object and merges the elements if there is a overlap in the ranges
     * @param zipCodesList - Input zip code list provided by the source
     * @return minimum zip code ranges
     */
    public List<ZipCode> minimumRangesRequired(List<ZipCode> zipCodesList) throws InvalidZipCodeRangeException {
        zipRangeValidator.validateZipCodeRanges(zipCodesList);
        zipCodesList.sort(zipRangeComparator);
        LinkedList<ZipCode> minimumRanges = new LinkedList<>();
        zipCodesList.forEach(zipCode -> {
            if (minimumRanges.isEmpty() || (minimumRanges.getLast().getUpperBound() < zipCode.getLowerBound())) {
                minimumRanges.add(zipCode);
            } else {
                minimumRanges.getLast().setUpperBound(
                        max(minimumRanges.getLast().getUpperBound(), zipCode.getUpperBound()));
            }
        });
        return minimumRanges;
    }
}
