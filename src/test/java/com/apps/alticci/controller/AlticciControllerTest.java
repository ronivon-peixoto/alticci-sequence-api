package com.apps.alticci.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AlticciControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAlticciValueByIndex_WithInvalidIndexNumber_ShouldReturnBadRequest() throws Exception {
        mockMvc.perform(get("/alticci/{index}", -1)
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.timestamp", is(notNullValue())))
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isMap())
            .andExpect(jsonPath("$.errors", aMapWithSize(1)))
            .andExpect(jsonPath("$.errors", hasEntry("_getAlticciValueByIndex.index", "must be greater than or equal to 0")))
            .andExpect(jsonPath("$.details", is("uri=/alticci/" + -1)));
    }

    @ParameterizedTest
    @CsvSource({ "0, 0", "1, 1", "2, 1", "3, 1", "4, 2", "5, 2", "6, 3", "7, 4", "8, 5", "9, 7", "10, 9" })
    void getAlticciValueByIndex_WithValidIndexNumber_ShouldEqualTheExpectedReturn(int index, int valueExpected) throws Exception {
        mockMvc.perform(get("/alticci/{index}", index)
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", is(valueExpected)));
    }

}