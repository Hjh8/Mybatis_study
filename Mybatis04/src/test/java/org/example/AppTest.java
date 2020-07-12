package org.example;

import static org.junit.Assert.assertTrue;

import Util.MybatisUtil;
import dao.StudentDao;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

public class AppTest 
{
    @Test
    public void resultTypeTest()
    {
        StudentDao dao = MybatisUtil.getSelSession().getMapper(StudentDao.class);
        Student stu = dao.selectStudentName(2018105555);
        System.out.println(stu);
    }

    @Test
    public void resultTypeAlias()
    {
        StudentDao dao = MybatisUtil.getSelSession().getMapper(StudentDao.class);
        Student stu = dao.selectStudentAlias(2018105555);
        System.out.println(stu);
    }

    @Test
    public void resultTypeAPackage()
    {
        StudentDao dao = MybatisUtil.getSelSession().getMapper(StudentDao.class);
        Student stu = dao.selectStudentPackage(2018105555);
        System.out.println(stu);
    }

    @Test
    public void resultTypeIsMap()
    {
        StudentDao dao = MybatisUtil.getSelSession().getMapper(StudentDao.class);
        Map<Object,Object> stu = dao.selectStudentToMap(2018105555);
        System.out.println(stu);
    }

    @Test
    public void resultMapTest()
    {
        StudentDao dao = MybatisUtil.getSelSession().getMapper(StudentDao.class);
        Student stu = dao.selectStudentResultMap(2018105555);
        System.out.println(stu);
    }
}
