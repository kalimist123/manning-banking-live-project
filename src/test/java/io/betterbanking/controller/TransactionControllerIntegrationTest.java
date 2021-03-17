package io.betterbanking.controller;
import io.betterbanking.model.Transaction;
import io.betterbanking.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerIntegrationTest {

    @Autowired MockMvc mvc;

    @MockBean
    TransactionService transactionService;

    @Test
    void getTransactions() throws Exception {

        when(transactionService.findAllTransactionsByAccountNumber(Mockito.anyInt())).
                thenReturn(
                        List.of(
                                new Transaction("credit", 1234567, "USD",
                                        100.00, "acme", "acme.png")));

        mvc.perform(get("/transactions/123234"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
        verify(transactionService, times(1)).findAllTransactionsByAccountNumber(Mockito.anyInt());

    }
}
