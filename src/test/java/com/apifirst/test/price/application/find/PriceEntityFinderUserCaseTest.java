package com.apifirst.test.price.application.find;

import com.apifirst.test.price.application.exception.PriceException;
import com.apifirst.test.price.application.find.dto.PriceRequest;
import com.apifirst.test.price.datatest.PriceMother;
import com.apifirst.test.price.domain.Price;
import com.apifirst.test.price.domain.PriceFinderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static com.apifirst.test.price.datatest.PriceMother.buildMockPrices;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PriceEntityFinderUserCaseTest {

    @Mock
    private PriceFinderRepository priceFinderRepository;

    @InjectMocks
    private PriceFinderUserCase priceFinderUserCase;

    @Test
    void shouldReturnPrice() {
        final Integer productId = PriceMother.productIdRandom();
        final Integer brandId = PriceMother.brandIdRandom();
        final LocalDateTime applyDate = PriceMother.applyDateRandom();
        final int priceList = 1;
        final List<Price> prices = buildMockPrices(productId, brandId, priceList);

        given(this.priceFinderRepository.findPriceByProductIdAndBrandIdAndApplyDate(productId, brandId, applyDate))
                .willReturn(prices);

        final Price price = this.priceFinderUserCase.getPrice(PriceRequest.builder()
                .applyDate(applyDate)
                .brandId(brandId)
                .productId(productId)
                .build());
        assertEquals(prices.get(1).getPrice(), price.getPrice());
        assertEquals(prices.get(1).getPriceList(), priceList);

    }

    @Test
    void shouldNotFoundPrice() {
        final Integer productId = PriceMother.productIdRandom();
        final Integer brandId = PriceMother.brandIdRandom();
        final LocalDateTime applyDate = PriceMother.applyDateRandom();

        given(this.priceFinderRepository.findPriceByProductIdAndBrandIdAndApplyDate(productId, brandId, applyDate))
                .willThrow(new PriceException("Not data found"));

        final PriceRequest priceRequest = PriceRequest.builder()
                .applyDate(applyDate)
                .brandId(brandId)
                .productId(productId)
                .build();
        assertThrows(PriceException.class, () -> this.priceFinderUserCase.getPrice(priceRequest));


    }

}
