package com.williamssonoma.codingchallenge.controller;

import com.williamssonoma.codingchallenge.domain.ZipCode;
import com.williamssonoma.codingchallenge.exception.InvalidZipCodeRangeException;
import com.williamssonoma.codingchallenge.service.ZipRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sai Dinesh Chandaluri
 */
@RestController
@RequestMapping("/zip/ranges")
public class ZipRangeController {

    private final ZipRangeService zipRangeService;

    public ZipRangeController(ZipRangeService zipRangeService) {
        this.zipRangeService = zipRangeService;
    }

    @PostMapping
    public List<ZipCode> zipRanges(@RequestBody List<ZipCode> zipCodeList) throws InvalidZipCodeRangeException {
        return zipRangeService.minimumRangesRequired(zipCodeList);
    }
}
