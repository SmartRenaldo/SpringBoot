package com.awesome.service.impl.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class MessageListener2 {

    @RabbitListener(queues = "direct queue")
    public void receive(String id) {
        System.out.println("Finish SMS send (rabbitMQ direct two). Id: " + id);
    }

}
