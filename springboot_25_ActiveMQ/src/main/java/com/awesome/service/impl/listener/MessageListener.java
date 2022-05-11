package com.awesome.service.impl.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "order.queue.id")
    @SendTo("another.order.queue.id")
    public String receive(String id) {
        System.out.println("Finish SMS send. Id: " + id);
        return "This. Id: " + id;
    }
}
