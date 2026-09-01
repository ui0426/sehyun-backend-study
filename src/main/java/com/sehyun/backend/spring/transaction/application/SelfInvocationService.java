package com.sehyun.backend.spring.transaction.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SelfInvocationService {

    @Transactional
    public void outer() {
        inner();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void inner() {
        System.out.println("inner");
    }
}