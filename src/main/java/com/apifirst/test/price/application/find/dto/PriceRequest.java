package com.apifirst.test.price.application.find.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PriceRequest {

    private Integer productId;
    private Integer brandId;
    private LocalDateTime applyDate;
}
