package io.betterbanking.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    TransactionService transactionService = new TransactionService();

    @Test
    void findAllByAccountNumber() {

        assertTrue(transactionService.findAllTransactionsByAccountNumber(123).size()>0);

    }
}