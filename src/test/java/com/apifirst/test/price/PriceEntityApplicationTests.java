package com.apifirst.test.price;

import com.apifirst.test.price.infrastructure.generate.model.PriceResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.apifirst.test.price.datatest.PriceMother.buildURL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class PriceEntityApplicationTests {

    private final Integer PRODUCT_ID = 35455;
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int randomServerPort;

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (NELSON) (2020-06-14-10.00.00)")
    void testOneShouldReturnPriorityEqualOne() {
        final String applyDate = "2020-06-14-10.00.00";

        final ResponseEntity<PriceResponse> response = this.invoke(applyDate);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(this.PRODUCT_ID, response.getBody().getProductId());
    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (NELSON)")
    void testTwoShouldReturnPriorityEqualTwo() {
        final String applyDate = "2020-06-14-16.00.00";
        final Integer priceListExpected = 2;

        final ResponseEntity<PriceResponse> response = this.invoke(applyDate);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(priceListExpected, response.getBody().getPriceList());
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (NELSON)")
    void testThreeShouldReturnPriorityEqualOne() {
        final String applyDate = "2020-06-14-21.00.00";
        final Integer priceListExpected = 1;

        final ResponseEntity<PriceResponse> response = this.invoke(applyDate);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(priceListExpected, response.getBody().getPriceList());
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (NELSON)")
    void testForShouldReturnPriorityEqualThree() {
        final String applyDate = "2020-06-15-10.00.00";
        final Integer priceListExpected = 3;

        final ResponseEntity<PriceResponse> response = this.invoke(applyDate);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(priceListExpected, response.getBody().getPriceList());
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (NELSON)")
    void testFiveShouldReturnPriorityEqualFor() {
        final String applyDate = "2020-06-16-21.00.00";
        final Integer priceListExpected = 4;

        final ResponseEntity<PriceResponse> response = this.invoke(applyDate);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(priceListExpected, response.getBody().getPriceList());
    }

    @Test
    @DisplayName("Not data found")
    void testNotDataFound() {
        final String applyDate = "2021-06-16-21.00.00";
        final ResponseEntity<PriceResponse> response = this.invoke(applyDate);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    private ResponseEntity<PriceResponse> invoke(final String applyDate) {
        final Integer brandId = 1;
        return this.restTemplate
                .getForEntity(buildURL(this.randomServerPort, this.PRODUCT_ID, brandId, applyDate), PriceResponse.class);

    }

}
