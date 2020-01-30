package com.williamssonoma.codingchallenge.util;

import com.williamssonoma.codingchallenge.domain.ZipCode;

public class TestUtil {
    public static ZipCode setZipCodeRange(int lowerBound, int upperBound) {
        ZipCode zipCode = new ZipCode();
        zipCode.setLowerBound(lowerBound);
        zipCode.setUpperBound(upperBound);
        return zipCode;
    }
}
