package com.apifirst.test.price.datatest;

import java.time.LocalDateTime;
import java.util.Random;

public final class PriceMother {

    public static final String URL = "http://localhost:";
    public static final String BASE_PATH = "/prices";
    public static final String PRODUCT_ID_PARAM = "productId";
    public static final String BRAND_ID_PARAM = "brandId";
    public static final String APPLY_DATE_PARAM = "applyDate";

    public static Integer productIdRandom() {
        return new Random().nextInt();
    }

    public static Integer brandIdRandom() {
        return new Random().nextInt();
    }

    public static LocalDateTime applyDateRandom() {
        return LocalDateTime.now();
    }

}
