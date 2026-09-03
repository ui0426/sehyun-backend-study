package com.sehyun.backend.db.lock;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LockService {

    private final LockMapper lockMapper;

    public LockService(LockMapper lockMapper) {
        this.lockMapper = lockMapper;
    }

    @Transactional
    public void pessimisticWithdraw(Long accountId, long amount) {
        Account account = lockMapper.findByIdForUpdate(accountId);

        if (account.getBalance() < amount) {
            throw new IllegalStateException("잔액 부족");
        }

        lockMapper.updateBalance(
                accountId,
                account.getBalance() - amount
        );
    }

    @Transactional
    public void optimisticWithdraw(Long accountId, long amount) {
        Account account = lockMapper.findById(accountId);

        if (account.getBalance() < amount) {
            throw new IllegalStateException("잔액 부족");
        }

        int updatedRows = lockMapper.updateWithVersion(
                accountId,
                account.getBalance() - amount,
                account.getVersion()
        );

        if (updatedRows == 0) {
            throw new IllegalStateException("Optimistic Lock 충돌");
        }
    }

    @Transactional
    public void transfer(Long fromId, Long toId, long amount) {
        Long firstId = Math.min(fromId, toId);
        Long secondId = Math.max(fromId, toId);

        lockMapper.findByIdForUpdate(firstId);
        lockMapper.findByIdForUpdate(secondId);

        Account from = lockMapper.findById(fromId);
        Account to = lockMapper.findById(toId);

        if (from.getBalance() < amount) {
            throw new IllegalStateException("잔액 부족");
        }

        lockMapper.updateBalance(
                fromId,
                from.getBalance() - amount
        );

        lockMapper.updateBalance(
                toId,
                to.getBalance() + amount
        );
    }
}