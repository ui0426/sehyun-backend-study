package com.sehyun.backend.spring.ioc.application;

import com.sehyun.backend.spring.ioc.port.MemberReader;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberReader memberReader;

    public MemberService(MemberReader memberReader) {
        this.memberReader = memberReader;
    }

    public String getMemberName(Long memberId) {
        return memberReader.findMemberName(memberId);
    }
}