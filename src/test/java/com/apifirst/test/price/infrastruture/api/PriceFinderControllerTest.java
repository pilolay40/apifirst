package com.apifirst.test.price.infrastruture.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.apifirst.test.price.datatest.PriceMother.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceFinderController.class)
class PriceFinderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPriceHappyPath() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH)
                .param(PRODUCT_ID_PARAM, String.valueOf(productIdRandom()))
                .param(BRAND_ID_PARAM, String.valueOf(brandIdRandom()))
                .param(APPLY_DATE_PARAM, String.valueOf(applyDateRandom())))
                .andExpect(status().isOk());
    }
}
