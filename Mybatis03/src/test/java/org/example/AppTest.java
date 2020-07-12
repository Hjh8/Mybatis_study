package org.example;

import static org.junit.Assert.assertTrue;

import Util.MybatisUtil;
import dao.StudentDao;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppTest 
{
    @Test
    public void OneSimpleParamTest()
    {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectByID(2018105555);
        System.out.println(student);
    }

    @Test
    public void MultiByParamTest()
    {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiByParam("codekiang",18);
        students.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void MultiByObjTest()
    {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("codekiang");
        student.setAge(18);
        List<Student> students = dao.selectMultiByObj(student);
        students.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void MultiByObjPositionTest()
    {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiByPosition("codekiang", 18);
        students.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void MultiByObjMapTest()
    {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("myname", "codekiang");
        map.put("myage",18);
        List<Student> students = dao.selectMultiByMap(map);
        students.forEach(stu -> System.out.println(stu));
    }
}
