package com.awesome.service.impl;

import com.awesome.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("SMS has been added to the message queue (kafka). Id: " + id);
        kafkaTemplate.send("awesome", id);
    }

    @Override
    public String handleMessage() {
//        String remove = kafkaTemplate.receiveAndConvert("order.queue.id", String.class);
//        System.out.println("Finish SMS send. Id: " + remove);
//        return remove;
        return null;
    }
}
