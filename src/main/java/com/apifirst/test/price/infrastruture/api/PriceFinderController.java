package com.apifirst.test.price.infrastruture.api;


import com.apifirst.test.price.infrastructure.generate.api.PricesApi;
import com.apifirst.test.price.infrastructure.generate.model.PriceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PriceFinderController implements PricesApi {

    @Override
    public ResponseEntity<PriceResponse> getPrice(@NotNull @Valid final Integer productId,
                                                  @NotNull @Valid final Integer brandId,
                                                  @NotNull @Valid final String applyDate) {
        return ResponseEntity.ok().build();
    }
}
