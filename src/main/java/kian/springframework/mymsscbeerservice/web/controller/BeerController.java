package kian.springframework.mymsscbeerservice.web.controller;

import kian.springframework.mymsscbeerservice.web.model.Beer;
import kian.springframework.mymsscbeerservice.web.repository.BeerRepository;
import kian.springframework.mymsscbeerservice.web.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<Beer> getBeerById(@PathVariable("beerId") String beerId) {
        Optional<Beer> beer = beerService.beerRepository.findById(beerId);

        return beer.map(
                value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody Beer beer) {
        Beer savedBeer = beerService.beerRepository.save(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId());

        return new ResponseEntity(headers ,HttpStatus.CREATED);
    }

    @PutMapping("/{beerName}/{price}")
    public ResponseEntity updateBeerPriceByName(
            @PathVariable("beerName") String beerName,
            @PathVariable("price") BigDecimal price
    ) {
        return new ResponseEntity(beerService.updateBeerPrice(beerName, price), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable("beerId") String beerId) {
        beerService.beerRepository.deleteById(beerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
