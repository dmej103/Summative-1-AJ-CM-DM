package com.company.summativeProject1.controller;


import ch.qos.logback.core.status.Status;
import com.company.summativeProject1.controllers.Magic8BallController;
import com.company.summativeProject1.models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
    public void shouldReturnMagic8BallAnswerOnPostRequest() throws Exception {
        Answer inputQuestion = new Answer("Netflix", "Test--1",1);

        String inputJson = mapper.writeValueAsString(inputQuestion);

        Answer outputAnswer = new Answer("", "Test--2", 2);

        String outputJson = mapper.writeValueAsString(outputAnswer);

        mockMvc.perform(
                        post("/magic8ball/answers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());   //Created status should be 201.
    }
}
