package com.sehyun.backend.db.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final AccountMapper accountMapper;

    public TransactionService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Transactional
    public void transfer(Long fromId, Long toId, long amount) {
        accountMapper.withdraw(fromId, amount);
        accountMapper.deposit(toId, amount);
    }

    @Transactional
    public void transferWithError(Long fromId, Long toId, long amount) {
        accountMapper.withdraw(fromId, amount);

        throw new RuntimeException("강제 예외");

        // 여기까지 실행되지 않음
        // accountMapper.deposit(toId, amount);
    }

    public Account findAccount(Long accountId) {
        return accountMapper.findById(accountId);
    }
}