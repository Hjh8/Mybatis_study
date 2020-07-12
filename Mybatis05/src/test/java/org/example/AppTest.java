package org.example;

import static org.junit.Assert.assertTrue;

import Util.MybatisUtil;
import dao.StudentDao;
import entity.Student;
import org.junit.Test;

import java.util.List;

public class AppTest 
{

    @Test
    public void selectStudentIfTest()
    {
        Student stu = new Student();
        stu.setName("xixi");
        stu.setAge(18);
        StudentDao dao = MybatisUtil.getSelSession().getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentIf(stu);
        students.forEach(s -> System.out.println(s));
    }

    @Test
    public void selectStudentWhereTest()
    {
        Student stu = new Student();
//        stu.setName("xixi");
        stu.setAge(18);
        StudentDao dao = MybatisUtil.getSelSession().getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentWhere(stu);
        students.forEach(s -> System.out.println(s));
    }

    @Test
    public void selectStudentForeachTest()
    {
        Student[] stus = new Student[3];
        stus[0] = new Student();
        stus[0].setAge(18);
        stus[1] = new Student();
        stus[1].setAge(20);
        stus[2] = new Student();
        stus[2].setAge(22);

        StudentDao dao = MybatisUtil.getSelSession().getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentForeach(stus);
        students.forEach(s -> System.out.println(s));
    }
}
