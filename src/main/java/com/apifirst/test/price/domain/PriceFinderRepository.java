package com.apifirst.test.price.domain;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceFinderRepository {
    
    List<Price> findPriceByProductIdAndBrandIdAndApplyDate(Integer productId, Integer brandId, LocalDateTime applyDate);
}
