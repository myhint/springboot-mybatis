package com.example.oceanstar.demo.dao.mapper;

import com.example.oceanstar.demo.bean.Employee;

import java.util.List;

/**
 * @Description employee mapper interface
 * @Author blake
 * @Date 2019-04-01 16:23
 * @Version 1.0
 */
public interface EmployeeMapper {

    // @CacheNamespace
    // @CacheNamespaceRef
    Employee getEmpById(Integer id);

    Employee getEmpDeptByIdUsingM1(Integer id);

    Employee getEmpDeptByIdUsingM2(Integer id);

    List<Employee> getEmpByDeptId(Integer deptId);

}
