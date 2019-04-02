package com.example.oceanstar.demo.dao.mapper;

import com.example.oceanstar.demo.bean.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description mybatis操作员工employee数据表
 * @Author blake
 * @Date 2019-04-01 16:18
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class EmployeeMapperTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void getEmpById() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.getEmpById(1);

        log.info(" ============ 此次查询出员工信息：[{}] ============ ", employee);

    }

    @Test
    public void getEmpDeptByIdUsingM1() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee empDept = employeeMapper.getEmpDeptByIdUsingM1(1);

        log.info(" ============ 此次查询出员工部门信息：[{}] ============ ", empDept);

    }

    @Test
    public void getEmpDeptByIdUsingM2() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee empDept = employeeMapper.getEmpDeptByIdUsingM2(1);

        log.info(" ============ 此次查询出员工部门信息：[{}] ============ ", empDept);

    }

}
