package com.awesome;

import com.awesome.config.TknConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({TknConfig.class})
public class ConfigTest {

    @Autowired
    private String tkn;

    @Test
    void testTkn() {
        System.out.println(tkn);
    }

}
