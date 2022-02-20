package com.apifirst.test.price.infrastruture.api.mapper;


import com.apifirst.test.price.domain.Price;
import com.apifirst.test.price.infrastructure.generate.model.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.WARN)
public interface PriceResponseToPriceMapper {

    @Mapping(target = "productId", source = "productId")
    PriceResponse priceToPriceResponse(Price obj);
}
