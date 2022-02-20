package com.apifirst.test.price.infrastruture.db.repository;

import com.apifirst.test.price.domain.Price;
import com.apifirst.test.price.domain.PriceFinderRepository;
import com.apifirst.test.price.infrastruture.db.mapper.PriceEntityToPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceH2Repository implements PriceFinderRepository {

    private final SpringDataPriceRepository repository;
    private final PriceEntityToPrice priceEntityToPrice;

    @Override
    public List<Price> findPriceByProductIdAndBrandIdAndApplyDate(final Integer productId,
                                                                  final Integer brandId,
                                                                  final LocalDateTime applyDate) {

        return this.priceEntityToPrice.priceEntityToPrices(
                this.repository.findPriceByProductIdAndBrandIdAndApplyDate(productId, brandId, Timestamp.valueOf(applyDate)));
    }
}
