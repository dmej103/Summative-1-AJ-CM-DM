package com.company.summativeProject1.controller;

import com.company.summativeProject1.controllers.Magic8BallController;
import com.company.summativeProject1.models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Magic8BallController.class)
public class Magic8BallControllerTest {

    @Autowired
    public MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Answer> answerList;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void shouldReturnMagic8BallAnswerOnPostRequestWithNonEmptyInput() throws Exception {
        // Should return the question inside inputQuestion
        Answer inputQuestion = new Answer("Netflix", "should not return this",1);

        String inputJson = mapper.writeValueAsString(inputQuestion);

        Answer outputAnswer = new Answer("", "should return random answer from answer list", 2);

        String outputJson = mapper.writeValueAsString(outputAnswer);

        mockMvc.perform(
                        post("/magic")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());   //Created status should be 201.
    }

    @Test
    public void shouldReturnMagic8BallAnswerOnPostRequestWithEmptyInput() throws Exception {
        // Should return the question inside inputQuestion
        Answer inputQuestion = new Answer("", "should not return this",1);

        String inputJson = mapper.writeValueAsString(inputQuestion);

        Answer outputAnswer = new Answer("", "should return random answer from answer list", 2);

        String outputJson = mapper.writeValueAsString(outputAnswer);

        mockMvc.perform(
                        post("/magic")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());   //Created status should be 201.
    }
}
