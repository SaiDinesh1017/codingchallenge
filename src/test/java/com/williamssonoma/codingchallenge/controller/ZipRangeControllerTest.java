package com.williamssonoma.codingchallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.williamssonoma.codingchallenge.domain.ZipCode;
import com.williamssonoma.codingchallenge.service.ZipRangeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.williamssonoma.codingchallenge.util.TestUtil.setZipCodeRange;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ZipRangeController.class)
public class ZipRangeControllerTest {

    @MockBean
    private ZipRangeService zipRangeService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnMinimumZipRanges() throws Exception {
        List<ZipCode> zipCodesList = Arrays.asList(setZipCodeRange(11111,22222),
                setZipCodeRange(11121, 33333));
        when(zipRangeService.getMinimumRangesRequired(anyListOf(ZipCode.class))).thenReturn(Collections.singletonList(
                setZipCodeRange(11111, 33333)));
        mockMvc.perform(MockMvcRequestBuilders.post("/zip/ranges").content(mapper.writeValueAsString(zipCodesList))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].lowerBound").value(11111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].upperBound").value(33333))
                .andReturn().getResponse();

    }

    @Test
    public void shouldThrowBadRequestIfZipRangesAreLessThanFiveDigits() throws Exception {
        List<ZipCode> zipCodesList = Collections.singletonList(setZipCodeRange(1111, 22222));
        mockMvc.perform(MockMvcRequestBuilders.post("/zip/ranges").content(mapper.writeValueAsString(zipCodesList))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse();
    }
}
