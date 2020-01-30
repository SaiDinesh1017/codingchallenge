package com.williamssonoma.codingchallenge.controller;

import com.williamssonoma.codingchallenge.domain.ZipCode;
import com.williamssonoma.codingchallenge.exception.InvalidZipCodeRangeException;
import com.williamssonoma.codingchallenge.service.ZipRangeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller class is used expose zip ranges end point to get multiple sets of zip code ranges obtained from
 * multiple sources.
 * @author Sai Dinesh Chandaluri
 */
@Validated
@RestController
@RequestMapping("/zip/ranges")
public class ZipRangeController {

    private final ZipRangeService zipRangeService;

    public ZipRangeController(ZipRangeService zipRangeService) {
        this.zipRangeService = zipRangeService;
    }

    @PostMapping
    public List<ZipCode> zipRanges(@RequestBody @Valid List<ZipCode> zipCodeList) throws InvalidZipCodeRangeException {
        return zipRangeService.getMinimumRangesRequired(zipCodeList);
    }
}
