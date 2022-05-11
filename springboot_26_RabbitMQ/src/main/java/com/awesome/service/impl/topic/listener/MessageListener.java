package com.awesome.service.impl.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = "topic queue")
    public void receive(String id) {
        System.out.println("Finish SMS send (rabbitMQ topic 1). Id: " + id);
    }

    @RabbitListener(queues = "topic queue2")
    public void receive2(String id) {
        System.out.println("Finish SMS send (rabbitMQ topic 2). Id: " + id);
    }

}
