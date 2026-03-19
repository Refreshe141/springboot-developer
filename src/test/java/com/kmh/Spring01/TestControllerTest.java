package com.kmh.Spring01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TestRepository testRepository;

    @BeforeEach
    public void mockMvcSetup(){
        //실제 스프링 웹 컨텍스트를 사용해 MockMvc 테스트 환경을 초기화한다
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @DisplayName("getAllMembers: 맴버 조회에 성공.")
    @Test
    public void getAllMembers() throws Exception {
        // given
        Member savedMember = testRepository.save(new Member("홍길동"));

        // when
        final ResultActions result = mockMvc.perform(get("/test")
                .accept(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
    @AfterEach
    public void cleanUp(){
        testRepository.deleteAll();
    }
}