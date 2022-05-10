package com.awesome;

import com.awesome.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot23MailApplicationTests {

    @Autowired
    private MailService mailService;

    @Test
    void contextLoads() {
        mailService.send();
    }

}
