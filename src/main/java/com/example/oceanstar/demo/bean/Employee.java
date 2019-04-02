package com.example.oceanstar.demo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 员工信息
 * @Author blake
 * @Date 2019-04-01 16:20
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Employee {

    private Integer id;

    private String name;

    private String email;

    private Integer gender;

    private Integer dId;

    private Department dept;

    public Employee(String name, String email, Integer gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
