package kian.springframework.mymsscbeerservice.web.repository;

import kian.springframework.mymsscbeerservice.web.model.Beer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Basic MongoRepository without the need to use Mongo Template
 */
public interface BeerRepository extends MongoRepository<Beer, String> {

    @Query("{beerName:'?0'}")
    List<Beer> findByBeerName(String name);

    List<Beer> findByUpc(Long upc);
}
