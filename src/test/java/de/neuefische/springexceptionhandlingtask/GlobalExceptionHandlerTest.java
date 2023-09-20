package de.neuefische.springexceptionhandlingtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GlobalExceptionHandlerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    public void testHandleUnexpectedError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/cars"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.errorMessage").isNotEmpty())
                .andExpect(jsonPath("$.errorMessage").value(containsString("An unexpected error: ")))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }
}