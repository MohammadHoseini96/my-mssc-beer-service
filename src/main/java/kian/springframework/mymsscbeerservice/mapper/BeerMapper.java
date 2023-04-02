package kian.springframework.mymsscbeerservice.mapper;

import kian.springframework.mymsscbeerservice.domain.Beer;
import kian.springframework.mymsscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * @author Kian
 * @created 4/2/2023 - 9:20 AM
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto beerDto);

}
