package com.sehyun.backend.db.lock;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/db/lock")
public class LockController {

    private final LockService lockService;

    public LockController(LockService lockService) {
        this.lockService = lockService;
    }

    @PostMapping("/pessimistic-withdraw")
    public void pessimisticWithdraw(
            @RequestParam Long accountId,
            @RequestParam long amount
    ) {
        lockService.pessimisticWithdraw(accountId, amount);
    }

    @PostMapping("/optimistic-withdraw")
    public void optimisticWithdraw(
            @RequestParam Long accountId,
            @RequestParam long amount
    ) {
        lockService.optimisticWithdraw(accountId, amount);
    }

    @PostMapping("/transfer")
    public void transfer(
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam long amount
    ) {
        lockService.transfer(fromId, toId, amount);
    }
}