package com.sehyun.backend.db.isolation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/db/isolation")
public class IsolationController {

    private final IsolationService isolationService;

    public IsolationController(IsolationService isolationService) {
        this.isolationService = isolationService;
    }

    @GetMapping("/read-committed/{accountId}")
    public void readCommitted(
            @PathVariable Long accountId
    ) {
        isolationService.readCommitted(accountId);
    }

    @GetMapping("/repeatable-read/{accountId}")
    public void repeatableRead(
            @PathVariable Long accountId
    ) {
        isolationService.repeatableRead(accountId);
    }

    @PostMapping("/lock/{accountId}")
    public void pessimisticLock(
            @PathVariable Long accountId
    ) {
        isolationService.pessimisticLock(accountId);
    }

    @PostMapping("/withdraw")
    public boolean withdraw(
            @RequestParam Long accountId,
            @RequestParam long amount
    ) {
        return isolationService.withdraw(accountId, amount);
    }
}