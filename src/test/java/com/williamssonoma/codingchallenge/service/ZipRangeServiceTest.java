package com.williamssonoma.codingchallenge.service;

import com.williamssonoma.codingchallenge.comparator.ZipRangeComparator;
import com.williamssonoma.codingchallenge.domain.ZipCode;
import com.williamssonoma.codingchallenge.exception.InvalidZipCodeRangeException;
import com.williamssonoma.codingchallenge.validator.ZipRangeValidator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.williamssonoma.codingchallenge.util.TestUtil.setZipCodeRange;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doCallRealMethod;

@RunWith(MockitoJUnitRunner.class)
public class ZipRangeServiceTest {

    @Spy
    private ZipRangeComparator zipRangeComparator;

    @Mock
    private ZipRangeValidator zipRangeValidator;

    @InjectMocks
    private ZipRangeService zipRangeService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void rangesShouldGetMergedToSingleRange() throws InvalidZipCodeRangeException {
        List<ZipCode> zipCodesList = Arrays.asList(setZipCodeRange(11111,22222),
                setZipCodeRange(11121, 33333));
        List<ZipCode> minimumRangesRequired = zipRangeService.getMinimumRangesRequired(zipCodesList);
        assertEquals(11111, minimumRangesRequired.get(0).getLowerBound().intValue());
        assertEquals(33333, minimumRangesRequired.get(0).getUpperBound().intValue());
    }

    @Test
    public void rangesShouldNotGetMerged() throws InvalidZipCodeRangeException {
        List<ZipCode> zipCodesList = Arrays.asList(setZipCodeRange(11111,22222),
                setZipCodeRange(33333, 66666), setZipCodeRange(77777, 77777));
        List<ZipCode> minimumRangesRequired = zipRangeService.getMinimumRangesRequired(zipCodesList);
        assertEquals(3, minimumRangesRequired.size());
        assertEquals(11111, minimumRangesRequired.get(0).getLowerBound().intValue());
        assertEquals(22222, minimumRangesRequired.get(0).getUpperBound().intValue());
        assertEquals(33333, minimumRangesRequired.get(1).getLowerBound().intValue());
        assertEquals(66666, minimumRangesRequired.get(1).getUpperBound().intValue());
        assertEquals(77777, minimumRangesRequired.get(2).getLowerBound().intValue());
        assertEquals(77777, minimumRangesRequired.get(2).getUpperBound().intValue());
    }

    @Test
    public void shouldThrowInvalidZipCodeRangeException() throws InvalidZipCodeRangeException {
        List<ZipCode> zipCodesList = Arrays.asList(setZipCodeRange(88888,22222),
                setZipCodeRange(33333, 66666));
        doCallRealMethod().when(zipRangeValidator).validateZipCodeRanges(zipCodesList);
        expectedException.expect(InvalidZipCodeRangeException.class);
        expectedException.expectMessage("Zip code range is invalid - The lower bound is greater than upper bound");
        zipRangeService.getMinimumRangesRequired(zipCodesList);
    }
}
