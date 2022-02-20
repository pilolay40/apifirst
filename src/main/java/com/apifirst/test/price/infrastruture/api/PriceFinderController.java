package com.apifirst.test.price.infrastruture.api;


import com.apifirst.test.price.application.find.PriceFinderUserCase;
import com.apifirst.test.price.application.find.dto.PriceRequest;
import com.apifirst.test.price.infrastructure.generate.api.PricesApi;
import com.apifirst.test.price.infrastructure.generate.model.PriceResponse;
import com.apifirst.test.price.infrastruture.api.mapper.PriceResponseToPriceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.apifirst.test.price.shared.DateUtils.convertStringToLocalDate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PriceFinderController implements PricesApi {

    private final PriceFinderUserCase priceFinderUserCase;
    private final PriceResponseToPriceMapper priceResponseToPriceMapper;

    @Override
    public ResponseEntity<PriceResponse> getPrice(@NotNull @Valid final Integer productId,
                                                  @NotNull @Valid final Integer brandId,
                                                  @NotNull @Valid final String applyDate) {
        return ResponseEntity.ok()
                .body(this.priceResponseToPriceMapper
                        .priceToPriceResponse(
                                this.priceFinderUserCase.getPrice(PriceRequest.builder()
                                        .productId(productId)
                                        .brandId(brandId)
                                        .applyDate(convertStringToLocalDate(applyDate))
                                        .build())));
    }
}
