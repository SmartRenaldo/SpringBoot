package com.awesome.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("departments")
public class Department {
    private Integer departmentId;
    private String departmentName;
    private Integer managerId;
    private Integer locationId;
}
