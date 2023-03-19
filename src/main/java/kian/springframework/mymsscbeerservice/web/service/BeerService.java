package kian.springframework.mymsscbeerservice.web.service;

import com.mongodb.client.result.UpdateResult;
import kian.springframework.mymsscbeerservice.web.model.Beer;
import kian.springframework.mymsscbeerservice.web.repository.BeerRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BeerService {

    public final BeerRepository beerRepository;

    private MongoTemplate mongoTemplate;

    public BeerService(BeerRepository beerRepository, MongoTemplate mongoTemplate) {
        this.beerRepository = beerRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Long updateBeerPrice(String beerName, BigDecimal price) {
        Query query = new Query(Criteria.where("beerName").is(beerName));
        Update update = new Update();
        update.set("price", price);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Beer.class);

        return result.getModifiedCount();
    }
}
