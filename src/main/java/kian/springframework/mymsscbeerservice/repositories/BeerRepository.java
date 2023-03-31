package kian.springframework.mymsscbeerservice.repositories;

import kian.springframework.mymsscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @author Kian
 * @created 3/31/2023 - 6:05 PM
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
