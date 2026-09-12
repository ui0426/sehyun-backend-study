package com.sehyun.backend.db.index;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface IndexMapper {

    Member findById(Long memberId);

    List<Member> findByStatus(String status);

    List<Member> findByStatusAndAge(
            @Param("status") String status,
            @Param("age") Integer age
    );

    List<Member> findByMemberAndCreatedAt(
            @Param("memberId") Long memberId,
            @Param("createdAt") LocalDateTime createdAt
    );
}