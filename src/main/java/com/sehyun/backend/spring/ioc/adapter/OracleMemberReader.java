package com.sehyun.backend.spring.ioc.adapter;

import com.sehyun.backend.spring.ioc.port.MemberReader;
import org.springframework.stereotype.Repository;

@Repository
public class OracleMemberReader implements MemberReader {

    @Override
    public String findMemberName(Long memberId) {
        return "member-" + memberId;
    }
}