package kian.springframework.mymsscbeerservice.web.model;

import kian.springframework.mymsscbeerservice.web.utility.enums.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.OffsetDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("Beer")
public class Beer {

    @Id
    private String id;
    private Integer version;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;

    private String beerName;

    private BeerStyleEnum beerStyleEnum;

    private Long upc;

    private BigDecimal price;

    private Integer quantityOnHand;

}
