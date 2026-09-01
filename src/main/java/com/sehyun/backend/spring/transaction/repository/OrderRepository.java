package com.sehyun.backend.spring.transaction.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public void save() {
        System.out.println("save order");
    }
}