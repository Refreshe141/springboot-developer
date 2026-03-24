package com.kmh.Spring01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    @DisplayName("GET /test 요청 시 Hello world 반환")
    void getTestAPI() throws Exception {

        mockMvc.perform(post("/test"))
                .andExpect(status().isCreated())
                .andExpect(content().string("Hello world"))
                .andDo(print());
    }

    @PostMapping("test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("Hello world", HttpStatus.CREATED);
    }
}