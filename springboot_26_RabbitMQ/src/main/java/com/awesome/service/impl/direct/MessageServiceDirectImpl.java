package com.awesome.service.impl.direct;

import com.awesome.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MessageServiceDirectImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("SMS has been added to the message queue (rabbitMQ direct). Id: " + id);
        amqpTemplate.convertAndSend("directExchange", "direct", id);
    }

    @Override
    public String handleMessage() {
        return null;
    }
}
