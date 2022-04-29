package com;

import com.awesome.Springboot04IntegrateJunitApplication;
import com.awesome.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// if the test class is not in the current package or its children package, we should specify the bootstrap class
@SpringBootTest(classes = Springboot04IntegrateJunitApplication.class)
class Springboot04IntegrateJunitApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        bookDao.save();
        System.out.println("two...");
    }

}
