package io.prochyra.flashcardapp.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class WebIntegrationTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    void getOfHomepageReturns200() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}
