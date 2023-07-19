package com.company.summativeProject1.controller;

import com.company.summativeProject1.controllers.DefinitionController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DefinitionController.class)
public class DefinitionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnRandomWordDefinitionAndReturn200StatusCode() throws Exception {
        mockMvc.perform(
                        get("/word")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
