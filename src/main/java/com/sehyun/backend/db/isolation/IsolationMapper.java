package com.sehyun.backend.db.isolation;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IsolationMapper {

    Account findById(Long accountId);

    int updateBalance(
            @Param("accountId") Long accountId,
            @Param("balance") long balance
    );

    Account findByIdForUpdate(Long accountId);

    int withdraw(
            @Param("accountId") Long accountId,
            @Param("amount") long amount
    );
}