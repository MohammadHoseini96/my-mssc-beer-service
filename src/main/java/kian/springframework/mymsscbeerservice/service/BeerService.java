package kian.springframework.mymsscbeerservice.service;

import kian.springframework.mymsscbeerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * Created By Kian on 2023-04-07.
 */
public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
