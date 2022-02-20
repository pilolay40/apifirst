package com.apifirst.test.price.infrastruture.db.mapper;

import com.apifirst.test.price.infrastruture.db.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.WARN)
public interface PriceEntityToPrice {

    @Mapping(target = "productId", source = "productId")
    com.apifirst.test.price.domain.Price priceEntityToPrice(PriceEntity entity);

    List<com.apifirst.test.price.domain.Price> priceEntityToPrices(List<PriceEntity> entity);
}
