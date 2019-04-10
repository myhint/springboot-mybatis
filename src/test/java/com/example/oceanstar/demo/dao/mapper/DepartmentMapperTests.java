package com.example.oceanstar.demo.dao.mapper;

import com.example.oceanstar.demo.bean.Department;
import com.example.oceanstar.demo.utils.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description mybatis操作部门department数据表
 * =====> <collection><collection/>标签的使用
 * @Author blake
 * @Date 2019-03-17 11:31
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class DepartmentMapperTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void getDeptById() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = departmentMapper.getDeptById(1);

        log.info(" ========= department: {} ========= ", department);

        sqlSession.close();
    }

    @Test
    public void insertDept() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department dept = new Department("Go服务端");

        departmentMapper.insertDept(dept);

        log.info(" =========== 此次生成主键id为：[{}] =========== ", dept.getId());

        // 关闭sqlSession会话
        sqlSession.close();
    }

    @Test
    public void getDeptEmpByIdM1() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department deptEmp = departmentMapper.getDeptEmpByIdM1(1);

        log.info(" =========== 查询出部门及员工信息：[{}] =========== ", deptEmp);

        sqlSession.close();
    }

    @Test
    public void getDeptEmpByIdM2() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department deptEmp = departmentMapper.getDeptEmpByIdM2(1);

        log.info(" =========== 查询出部门及员工信息：[{}] =========== ", deptEmp);

        sqlSession.close();
    }

    // foreach： where in (...) and parameter type is list
    @Test
    public void listDeptByIds() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departments = departmentMapper.listDeptByIds(Arrays.asList(1, 2));

        if (CollectionUtil.isNotEmpty(departments)) {
            departments.forEach(item -> log.info(" ========= 部门：[{}] ========= ", item));
        }

        sqlSession.close();
    }

    // foreach： where in (...) and parameter type is map
    @Test
    public void listDeptByIdsWithMap() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Map<String, List<Integer>> deptIdMap = new HashMap<>();
        deptIdMap.put("deptIds", Arrays.asList(1, 2));

        List<Department> departments = departmentMapper.listDeptByIdsWithMap(deptIdMap);

        if (CollectionUtil.isNotEmpty(departments)) {
            departments.forEach(item -> log.info(" ========= 部门：[{}] ========= ", item));
        }

        sqlSession.close();
    }

    // foreach: batch insert with list|set
    @Test
    public void batchInsertDept() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department dept1 = new Department("Dept01");
        Department dept2 = new Department("Dept02");

        List<Department> depts = new ArrayList<>();
        depts.add(dept1);
        depts.add(dept2);

        departmentMapper.batchInsertDept(depts);

        sqlSession.close();
    }

    // foreach: batch insert with map
    @Test
    public void batchInsertDeptWithMap() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department dept1 = new Department("Dept01");
        Department dept2 = new Department("Dept02");

        List<Department> depts = new ArrayList<>();
        depts.add(dept1);
        depts.add(dept2);

        Map<String, List<Department>> deptMap = new HashMap<>();
        deptMap.put("depts", depts);

        departmentMapper.batchInsertDeptWithMap(deptMap);

        sqlSession.close();
    }

    // foreach: batch update with list|set
    @Test
    public void batchUpdateDept() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department dept1 = new Department(1, "Dept01");
        Department dept2 = new Department(2, "Dept02");

        List<Department> depts = new ArrayList<>();
        depts.add(dept1);
        depts.add(dept2);

        departmentMapper.batchUpdateDept(depts);

        List<Department> departments = departmentMapper.listDeptByIds(Arrays.asList(1, 2));

        if (CollectionUtil.isNotEmpty(departments)) {
            departments.forEach(item -> log.info(" ======== 部门：[{}] ======== ", item));
        }

        sqlSession.close();
    }

    // foreach: batch update with list|set
    @Test
    public void batchUpdateDeptWithMap() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department dept1 = new Department(1, "Dept01");
        Department dept2 = new Department(2, "Dept02");

        List<Department> depts = new ArrayList<>();
        depts.add(dept1);
        depts.add(dept2);

        Map<String, List<Department>> deptMap = new HashMap<>();
        deptMap.put("depts", depts);

        departmentMapper.batchUpdateDeptWithMap(deptMap);

        List<Department> departments = departmentMapper.listDeptByIds(Arrays.asList(1, 2));

        if (CollectionUtil.isNotEmpty(departments)) {
            departments.forEach(item -> log.info(" ======== 部门：[{}] ======== ", item));
        }

        sqlSession.close();
    }
}
