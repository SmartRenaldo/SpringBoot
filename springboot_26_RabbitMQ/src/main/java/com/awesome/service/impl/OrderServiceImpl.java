package com.awesome.service.impl;

import com.awesome.service.MessageService;
import com.awesome.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MessageService messageService;

    @Override
    public void order(String id) {
        System.out.println("start...");
        messageService.sendMessage(id);
        System.out.println("finish...");
        System.out.println();
    }
}
