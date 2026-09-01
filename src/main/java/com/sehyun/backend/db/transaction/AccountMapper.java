package com.sehyun.backend.db.transaction;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    Account findById(Long accountId);

    int withdraw(
            @Param("accountId") Long accountId,
            @Param("amount") long amount
    );

    int deposit(
            @Param("accountId") Long accountId,
            @Param("amount") long amount
    );
}