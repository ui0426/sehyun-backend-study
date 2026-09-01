package com.sehyun.backend.spring.transaction.adapter;

import com.sehyun.backend.spring.transaction.application.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TransactionRunner implements CommandLineRunner {

    private final OrderService orderService;

    public TransactionRunner(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        orderService.createOrder();
    }
}