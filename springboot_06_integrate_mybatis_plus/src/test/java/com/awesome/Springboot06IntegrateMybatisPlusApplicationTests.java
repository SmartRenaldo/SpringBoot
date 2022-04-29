package com.awesome;

import com.awesome.domain.Department;
import com.awesome.mapper.DepartmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot06IntegrateMybatisPlusApplicationTests {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    void contextLoads() {
        System.out.println(departmentMapper.selectList(null));
    }

}
