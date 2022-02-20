package com.apifirst.test.price.datatest;

import com.apifirst.test.price.domain.Price;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class PriceMother {

    public static final String URL = "http://localhost:";
    public static final String BASE_PATH = "/prices";
    public static final String PRODUCT_ID_PARAM = "productId";
    public static final String BRAND_ID_PARAM = "brandId";
    public static final String APPLY_DATE_PARAM = "applyDate";
    public static final String PRICE_PARAM = "price";
    public static final String PRICE_LIST_PARAM = "priceList";

    public static Integer productIdRandom() {
        return new Random().nextInt();
    }

    public static Integer brandIdRandom() {
        return new Random().nextInt();
    }

    public static LocalDateTime applyDateRandom() {
        return LocalDateTime.now();
    }

    public static String buildURL(final int port, final Integer productId, final Integer brandId, final String applyDate) {
        return URL + port + BASE_PATH + "?" + PRODUCT_ID_PARAM
                + "=" + productId + "&" + BRAND_ID_PARAM + "=" + brandId + "&" + APPLY_DATE_PARAM + "=" + applyDate;
    }

    public static List<Price> buildMockPrices(final Integer productId, final Integer brandId, final int priceList) {
        final List<Price> prices = new ArrayList<>();
        prices.add(Price.builder()
                .productId(productId)
                .brandId(brandId)
                .priceList(20)
                .build());
        prices.add(Price.builder()
                .productId(productId)
                .brandId(brandId)
                .priceList(priceList)
                .build());
        final Price price = new Price();
        return prices;
    }

}
