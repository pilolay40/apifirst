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

import java.time.format.DateTimeFormatter;

import static com.apifirst.test.price.datatest.PriceMother.URL;
import static com.apifirst.test.price.datatest.PriceMother.buildURL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class PriceEntityApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int randomServerPort;

    @Test
    void shouldTestHappyPath() {

        final ResponseEntity<PriceResponse> response = this.restTemplate
                .getForEntity(URL + this.randomServerPort + "/prices?productId=55&brandId=56&applyDate=65 ", PriceResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA) (2020-06-14-10.00.00)")
    void testOne() {
        final Integer productID = 35455;
        final Integer brandId = 1;
        final String applyDate = "2020-06-14-10.00.00";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        //final LocalDateTime applyDate = LocalDateTime.parse(str, formatter);

        final ResponseEntity<PriceResponse> response = this.restTemplate
                .getForEntity(buildURL(this.randomServerPort, productID, brandId, applyDate), PriceResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(productID, response.getBody().getProductId());
    }

}
