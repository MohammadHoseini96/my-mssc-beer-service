package kian.springframework.mymsscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kian.springframework.mymsscbeerservice.bootstrap.BeerLoader;
import kian.springframework.mymsscbeerservice.service.BeerService;
import kian.springframework.mymsscbeerservice.web.model.BeerDto;
import kian.springframework.mymsscbeerservice.web.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        given(beerService.getById(any())).willReturn(getValidBeerDto());

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/beer/" + UUID.randomUUID())
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());

        mockMvc.perform(
                    MockMvcRequestBuilders
                            .post("/api/v1/beer/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(getValidBeerDto())))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        given(beerService.updateBeer(any(), any())).willReturn(getValidBeerDto());

        mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getValidBeerDto())))
                .andExpect(status().isNoContent());
    }

    BeerDto getValidBeerDto() {
        return BeerDto
                .builder()
                .beerName("My Beer")
                .beerStyle(BeerStyle.ALE)
                .price(new BigDecimal("2.93"))
                .upc(BeerLoader.BEER_1_UPC)
                .build();
    }

    @Test
    void deleteBeerById() {
        //todo - very similar to getBeerById
    }

    @Test
    void getBeerByUpc() {
        //todo - very similar to getBeerById
    }
}