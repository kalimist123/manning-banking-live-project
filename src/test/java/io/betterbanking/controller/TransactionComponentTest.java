package io.betterbanking.controller;
import io.betterbanking.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

public class TransactionComponentTest {

    @LocalServerPort
    private int port;

    @Test
    public void testApplicationEndToEnd() {

        given().
                standaloneSetup(new TransactionController(new TransactionService())).
                param("accountNumber", 123345).
                when().
                   get(String.format("http://localhost:%s/transactions/1234567", port)).
        then().
                statusCode(200);
    }

}
