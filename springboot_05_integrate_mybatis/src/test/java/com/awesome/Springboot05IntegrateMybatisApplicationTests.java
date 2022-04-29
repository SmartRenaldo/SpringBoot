package com.awesome;

import com.awesome.mapper.DepartmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05IntegrateMybatisApplicationTests {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    void contextLoads() {
        System.out.println(departmentMapper.getByDepartmentId(10));
    }

}
