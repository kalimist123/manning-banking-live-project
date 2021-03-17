package io.betterbanking.service;

import io.betterbanking.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    public List<Transaction> findAllTransactionsByAccountNumber(Integer accountNumber){
        return List.of( new Transaction("credit", 1234567, "USD", 100.00, "acme", "acme.png")
);
    }
}
