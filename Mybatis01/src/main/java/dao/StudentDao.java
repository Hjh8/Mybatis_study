package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {
    //  查询所有学生信息
    List<Student> selectStudents();
    //  通过名字模糊查询学生信息
    List<Student> selectStudentsLikeName(String name);
}
