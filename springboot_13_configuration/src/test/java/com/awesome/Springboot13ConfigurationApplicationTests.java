package com.awesome;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot13ConfigurationApplicationTests {

//    @Value("${servers.ipAddress}")
    @Value("${servers.ip-address}")
    private String msg;

    @Value("${datasource.password}")
    private String password;

    @Value("${beer.german}")
    private String german;

    @Test
    void contextLoads() {
        System.out.println(msg);
        System.out.println(password);
        System.out.println(german);
    }

}
