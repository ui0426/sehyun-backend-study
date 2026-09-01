package com.sehyun.backend.db.transaction;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/db/transaction/transfer")
    public void transfer(
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam long amount
    ) {
        transactionService.transfer(fromId, toId, amount);
    }

    @PostMapping("/db/transaction/rollback")
    public void rollback(
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam long amount
    ) {
        transactionService.transferWithError(fromId, toId, amount);
    }
}