package com.example.oceanstar.demo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Description 部门信息
 * @Author blake
 * @Date 2019-03-17 11:23
 * @Version 1.0
 */
@Data
@ToString
@NoArgsConstructor
public class Department {

    // 部门id
    private Integer id;

    // 部门名称
    private String departmentName;

    // 当前部门员工信息
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}
