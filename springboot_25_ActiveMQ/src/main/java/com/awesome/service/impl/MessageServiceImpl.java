package com.awesome.service.impl;

import com.awesome.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("SMS has been added to the message queue. Id: " + id);
        messagingTemplate.convertAndSend("order.queue.id", id);
    }

    @Override
    public String handleMessage() {
        String remove = messagingTemplate.receiveAndConvert("order.queue.id", String.class);
        System.out.println("Finish SMS send. Id: " + remove);
        return remove;
    }
}
