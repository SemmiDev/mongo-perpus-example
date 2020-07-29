package com.learn.amigoscode.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@Slf4j
public class PerpustakaanControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PerpustakaanController controller;

    @Test
    void getAllTest() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .get("/api/v1/perpustakaans/{id}", "5dcca46f76b99a6d2d86088c")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
        log.info("" + mvcResult.getResponse().getStatus());
    }
}
