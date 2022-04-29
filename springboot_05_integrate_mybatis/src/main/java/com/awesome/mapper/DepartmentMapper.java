package com.awesome.mapper;

import com.awesome.domain.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {
    @Select("select * from departments where department_id = #{departmentId}")
    Department getByDepartmentId(Integer departmentId);
}
