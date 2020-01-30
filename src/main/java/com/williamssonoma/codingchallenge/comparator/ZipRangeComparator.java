package com.williamssonoma.codingchallenge.comparator;

import com.williamssonoma.codingchallenge.domain.ZipCode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Comparator;

@Component
public class ZipRangeComparator implements Comparator<ZipCode>, Serializable {

    @Override
    public int compare(ZipCode zipCode1, ZipCode zipCode2) {
        if (zipCode1.getLowerBound() < zipCode2.getLowerBound())
            return -1;
        return zipCode1.getLowerBound().equals(zipCode2.getLowerBound()) ? 0 : 1;
    }
}
