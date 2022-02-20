package com.apifirst.test.price.infrastruture.api;

import com.apifirst.test.price.application.find.PriceFinderUserCase;
import com.apifirst.test.price.domain.Price;
import com.apifirst.test.price.infrastructure.generate.model.PriceResponse;
import com.apifirst.test.price.infrastruture.api.mapper.PriceResponseToPriceMapper;
import com.apifirst.test.price.shared.DateUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.apifirst.test.price.datatest.PriceMother.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceFinderController.class)
class PriceEntityFinderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceFinderUserCase priceFinderUserCase;

    @MockBean
    private PriceResponseToPriceMapper priceResponseToPriceMapper;

    @Test
    void getPriceHappyPath() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH)
                .param(PRODUCT_ID_PARAM, String.valueOf(productIdRandom()))
                .param(BRAND_ID_PARAM, String.valueOf(brandIdRandom()))
                .param(APPLY_DATE_PARAM, String.valueOf(applyDateRandom())))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA) (2020-06-14-10.00.00)")
    void testOne() throws Exception {
        final Integer productId = 35455;
        final Integer brandId = 1;
        final String applyDate = "2020-06-14-10.00.00";
        final Integer priceList = 1;


        final Price price = Price.builder()
                .productId(productId)
                .brandId(brandId)
                .startDate(DateUtils.convertStringToLocalDate(applyDate))
                .priceList(priceList)
                .price(35.50)
                .build();
        given(this.priceFinderUserCase.getPrice(any())).willReturn(price);
        final PriceResponse priceResponse = new PriceResponse();
        priceResponse.setProductId(price.getProductId());
        priceResponse.setBrandId(price.getBrandId());
        priceResponse.setApplyDate(price.getStartDate());
        priceResponse.setPriceList(priceList);
        priceResponse.setPrice(price.getPrice());
        given(this.priceResponseToPriceMapper.priceToPriceResponse(any())).willReturn(priceResponse);

        this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH)
                .param(PRODUCT_ID_PARAM, String.valueOf(productId))
                .param(BRAND_ID_PARAM, String.valueOf(brandId))
                .param(APPLY_DATE_PARAM, applyDate))
                .andExpect(status().isOk())
                .andExpect(jsonPath(PRODUCT_ID_PARAM).value(productId))
                .andExpect(jsonPath(BRAND_ID_PARAM).value(brandId))
                .andExpect(jsonPath(PRICE_LIST_PARAM).value(price.getPriceList()))
                .andExpect(jsonPath(PRICE_PARAM).value(price.getPrice()));
        verify(this.priceFinderUserCase).getPrice(any());
    }

}
