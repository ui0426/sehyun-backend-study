package com.sehyun.backend.db.isolation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IsolationService {

    private final IsolationMapper isolationMapper;

    public IsolationService(IsolationMapper isolationMapper) {
        this.isolationMapper = isolationMapper;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void readCommitted(Long accountId) {

        Account first = isolationMapper.findById(accountId);

        System.out.println("first = " + first.getBalance());

        // breakpoint를 걸고
        // 다른 DB Session에서 UPDATE + COMMIT 후 다시 실행

        Account second = isolationMapper.findById(accountId);

        System.out.println("second = " + second.getBalance());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void repeatableRead(Long accountId) {

        Account first = isolationMapper.findById(accountId);

        System.out.println("first = " + first.getBalance());

        // 다른 DB Session에서 UPDATE + COMMIT

        Account second = isolationMapper.findById(accountId);

        System.out.println("second = " + second.getBalance());
    }

    @Transactional
    public void pessimisticLock(Long accountId) {

        Account account = isolationMapper.findByIdForUpdate(accountId);

        System.out.println(account.getBalance());

        // 이 Transaction이 끝날 때까지
        // 같은 행을 수정하려는 다른 Transaction은 대기할 수 있음
    }

    @Transactional
    public boolean withdraw(Long accountId, long amount) {

        int updatedRows = isolationMapper.withdraw(accountId, amount);

        return updatedRows == 1;
    }
}