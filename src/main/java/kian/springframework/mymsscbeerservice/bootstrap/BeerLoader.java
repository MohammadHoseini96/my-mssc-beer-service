package kian.springframework.mymsscbeerservice.bootstrap;

import kian.springframework.mymsscbeerservice.domain.Beer;
import kian.springframework.mymsscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Kian
 * @created 3/31/2023 - 6:15 PM
 */

// CommandLineRunner is gonna run everytime the Spring Context starts

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(
                    Beer.builder()
                            .beerName("Mango Bobs")
                            .beerStyle("IPA")
                            .quantityToBrew(200)
                            .minOnHand(12)
                            .upc(337010000001L)
                            .price(new BigDecimal("12.95"))
                            .build()
            );

            beerRepository.save(
                    Beer.builder()
                            .beerName("Galaxy Cat")
                            .beerStyle("PALE_ALE")
                            .quantityToBrew(200)
                            .minOnHand(12)
                            .upc(337010000002L)
                            .price(new BigDecimal("11.95"))
                            .build()
            );
        }
    }
}
