package com.awesome;

import com.awesome.domain.ReadCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReadTest {
    @Autowired
    ReadCase readCase;

    @Test
    void testProp() {
        System.out.println(readCase);
    }

}
