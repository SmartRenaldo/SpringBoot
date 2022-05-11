package com.awesome.service.impl.topic;

import com.awesome.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceTopicImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("SMS has been added to the message queue (rabbitMQ topic). Id: " + id);
        amqpTemplate.convertAndSend("topicExchange", "topic.orders.id", id);
    }

    @Override
    public String handleMessage() {
        return null;
    }
}
