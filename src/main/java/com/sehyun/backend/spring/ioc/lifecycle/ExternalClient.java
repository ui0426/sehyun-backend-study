package com.sehyun.backend.spring.ioc.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ExternalClient {

    @PostConstruct
    public void init() {
        System.out.println("ExternalClient initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("ExternalClient destroyed");
    }
}