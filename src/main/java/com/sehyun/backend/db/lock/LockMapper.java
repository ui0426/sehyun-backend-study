package com.sehyun.backend.db.lock;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LockMapper {

    Account findById(Long accountId);

    Account findByIdForUpdate(Long accountId);

    int updateBalance(
            @Param("accountId") Long accountId,
            @Param("balance") long balance
    );

    int updateWithVersion(
            @Param("accountId") Long accountId,
            @Param("balance") long balance,
            @Param("version") long version
    );
}