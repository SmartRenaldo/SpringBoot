package com.awesome.service.impl;

import com.awesome.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageServiceImpl implements MessageService {

    private ArrayList<String> msgList = new ArrayList<>();

    @Override
    public void sendMessage(String id) {
        System.out.println("SMS has been added to the message queue. Id: " + id);
        msgList.add(id);
    }

    @Override
    public String handleMessage() {
        String remove = msgList.remove(0);
        System.out.println("Finish SMS send. Id: " + remove);
        return remove;
    }
}
