package com.example.oceanstar.demo.dao.mapper;

import com.example.oceanstar.demo.bean.Department;

import java.util.List;
import java.util.Map;

/**
 * @Description department mapper interface
 * @Author blake
 * @Date 2019-03-17 11:23
 * @Version 1.0
 */
public interface DepartmentMapper {

    Department getDeptById(Integer id);

    Department getDeptEmpByIdM1(Integer id);

    Department getDeptEmpByIdM2(Integer id);

    Integer insertDept(Department dept);

    List<Department> listDeptByIds(List<Integer> ids);

    List<Department> listDeptByIdsWithMap(Map<String, List<Integer>> deptIdMap);

    void batchInsertDept(List<Department> depts);

    void batchInsertDeptWithMap(Map<String, List<Department>> deptMap);

    void batchUpdateDept(List<Department> depts);

    void batchUpdateDeptWithMap(Map<String, List<Department>> deptMap);
}
