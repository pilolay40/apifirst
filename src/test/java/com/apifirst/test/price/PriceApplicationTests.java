package com.apifirst.test.price;

import com.apifirst.test.price.infrastructure.generate.model.PriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.apifirst.test.price.datatest.PriceMother.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class PriceApplicationTests {

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

}
