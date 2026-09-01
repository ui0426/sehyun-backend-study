package com.sehyun.backend.spring.transaction.application;

import com.sehyun.backend.spring.transaction.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final HistoryService historyService;

    public OrderService(
            OrderRepository orderRepository,
            HistoryService historyService
    ) {
        this.orderRepository = orderRepository;
        this.historyService = historyService;
    }

    @Transactional
    public void createOrder() {
        orderRepository.save();
        historyService.saveHistory();
    }
}