package io.betterbanking.controller;

import io.betterbanking.model.Transaction;
import io.betterbanking.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/transactions",
        produces="application/json")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){

        this.transactionService = transactionService;
    }
    @GetMapping("/{accountNumber}")
    public List<Transaction> findAllTransactionsForAccountNumber(@PathVariable("accountNumber") final Integer accountNumber){

        return this.transactionService.findAllTransactionsByAccountNumber(accountNumber);

    }

}
