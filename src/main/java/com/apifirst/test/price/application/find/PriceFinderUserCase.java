package com.apifirst.test.price.application.find;

import com.apifirst.test.price.application.exception.PriceNotFoundException;
import com.apifirst.test.price.application.find.dto.PriceRequest;
import com.apifirst.test.price.domain.Price;
import com.apifirst.test.price.domain.PriceFinderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceFinderUserCase {

    private final PriceFinderRepository priceFinderRepository;

    public Price getPrice(final PriceRequest priceRequest) {
        final List<Price> prices = this.priceFinderRepository
                .findPriceByProductIdAndBrandIdAndApplyDate(priceRequest.getProductId(),priceRequest.getBrandId(), priceRequest.getApplyDate());

        return prices.stream()
                .max(Comparator.comparingInt(Price::getPriceList))
                .orElseThrow(()->new PriceNotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase()));

    }
}
