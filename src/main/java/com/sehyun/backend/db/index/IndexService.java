package com.sehyun.backend.db.index;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IndexService {

    private final IndexMapper indexMapper;

    public IndexService(IndexMapper indexMapper) {
        this.indexMapper = indexMapper;
    }

    public Member findById(Long memberId) {
        return indexMapper.findById(memberId);
    }

    public List<Member> findByStatus(String status) {
        return indexMapper.findByStatus(status);
    }

    public List<Member> findByStatusAndAge(
            String status,
            Integer age
    ) {
        return indexMapper.findByStatusAndAge(status, age);
    }

    public List<Member> findByMemberAndCreatedAt(
            Long memberId,
            LocalDateTime createdAt
    ) {
        return indexMapper.findByMemberAndCreatedAt(
                memberId,
                createdAt
        );
    }
}