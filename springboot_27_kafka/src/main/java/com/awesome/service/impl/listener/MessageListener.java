package com.awesome.service.impl.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "awesome")
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("SMS has been added to the message queue (kafka). Id: " + record.value());
    }
}
