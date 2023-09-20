package de.neuefische.springexceptionhandlingtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    public void testGetAllCarsThrowNoSuchElementException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/cars"))
                .andExpect(status().isNotFound())
                .andExpect(content().json(
                        """
                        {
                            "errorMessage": "No Cars found"
                        }
                        """
                ));
    }

    @Test
    @DirtiesContext
    public void testGetCarBrandReturnPorsche() throws Exception {

        String brand = "porsche";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/" + brand))
                .andExpect(status().isOk())
                .andExpect(content().string(brand));
    }

    @Test
    @DirtiesContext
    public void testGetCarBrandThrowIllegalArgumentException() throws Exception {

        String brand = "vw";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/" + brand))
                .andExpect(status().isForbidden())
                .andExpect(content().json(
                        """
                        {
                            "errorMessage": "Only 'porsche' allowed"
                        }
                        """
                ));
    }
}
