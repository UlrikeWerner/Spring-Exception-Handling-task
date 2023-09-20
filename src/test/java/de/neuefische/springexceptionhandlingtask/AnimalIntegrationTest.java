package de.neuefische.springexceptionhandlingtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    public void testGetAllAnimalsThrowNoSuchElementException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/animals"))
                .andExpect(status().isNotFound())
                .andExpect(content().json(
                        """
                        {
                            "errorMessage": "No Animals found"
                        }
                        """
                ));
    }

    @Test
    @DirtiesContext
    public void testGetAnimalSpeciesReturnDog() throws Exception {

        String species = "dog";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/animals/" + species))
                .andExpect(status().isOk())
                .andExpect(content().string(species));
    }

    @Test
    @DirtiesContext
    public void testGetAnimalSpeciesThrowIllegalArgumentException() throws Exception {

        String species = "cat";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/animals/" + species))
                .andExpect(status().isForbidden())
                .andExpect(content().json(
                        """
                        {
                            "errorMessage": "Only 'dog' is allowed"
                        }
                        """
                ));
    }
}
