package org.example;

import Util.MybatisUtil;
import com.github.pagehelper.PageHelper;
import dao.StudentDao;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.*;

public class AppTest 
{
    @Test
    public void TestJdbcProperties()
    {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudent();
        System.out.println(students);
    }

    @Test
    public void TestPageHelper()
    {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // pageNum:第几页  pageSize：每页显示多少条数据
        PageHelper.startPage(1,2);
        List<Student> students = dao.selectAllStudent();
        System.out.println(students);
    }
}
