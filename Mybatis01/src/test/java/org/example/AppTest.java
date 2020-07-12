package org.example;

import static org.junit.Assert.assertTrue;

import entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AppTest 
{
    @Test
    public void SelectStudentLikeName() throws IOException {
        String config = "mybatis_conf.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId = "dao.StudentDao"+"."+"selectStudentsLikeName";

        String name = "%杭%";
        List<Student> students = sqlSession.selectList(sqlId, name);
        students.forEach(stu -> System.out.println(stu));

        sqlSession.close();
    }
}
