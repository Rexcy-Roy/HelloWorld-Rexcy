package com.example.hello.controller;

import com.example.hello.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GreetingService greetingService;
    @Test
    void testGreeting() throws Exception {

    String path="/";//

        when(greetingService.greet()).thenReturn("Hello, Mock");
        mockMvc.perform(get("/"))//initiates a GET request to the specified path.
                .andDo(print())// is used to print the request and response details to the console for debugging purposes.
                .andExpect(status().isOk())//asserts that the HTTP response status code is 200 (OK).
                .andExpect(content().string(containsString("Hello, World")));// checks that the response content contains the string "Hello, World."

    }
}
