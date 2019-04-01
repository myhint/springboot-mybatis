package com.example.oceanstar.demo.dao.mapper;

import com.example.oceanstar.demo.bean.Department;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @Description mybatis操作部门department数据表
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
    public void getDeptById() throws IOException {

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

}
