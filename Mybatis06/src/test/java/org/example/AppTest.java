package org.example;

import static org.junit.Assert.assertTrue;

import Util.MybatisUtil;
import dao.StudentDao;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest 
{

    @Test
    public void FirstCacheTest()
    {
        SqlSession sqlSession1 = MybatisUtil.getSelSession();
        StudentDao dao1 = sqlSession1.getMapper(StudentDao.class);
        Student stu1 = dao1.selectStudentByID(2018105555);
        System.out.println(stu1);

//        Student stu2 = dao.selectStudentByID(2018104444); // 没使用缓存
        Student stu2 = dao1.selectStudentByID(2018104444);  // 使用了缓存
        System.out.println(stu1==stu2);
        sqlSession1.close();
//        SqlSession sqlSession2 = MybatisUtil.getSelSession();
//        StudentDao dao2 = sqlSession2.getMapper(StudentDao.class);
//        Student stu2 = dao2.selectStudentByID(2018105555);
//        System.out.println(stu2);
//        sqlSession2.close();
    }

    @Test
    public void SecondCacheTest(){
        SqlSession sqlSession1 = MybatisUtil.getSelSession();
        StudentDao dao1 = sqlSession1.getMapper(StudentDao.class);
        Student stu1 = dao1.selectStudentByID(2018105555);
        System.out.println(stu1);
        sqlSession1.close();
        SqlSession sqlSession2 = MybatisUtil.getSelSession();
        StudentDao dao2 = sqlSession2.getMapper(StudentDao.class);
        Student stu2 = dao2.selectStudentByID(2018105555);
        System.out.println(stu2);
        sqlSession2.close();
    }
}
