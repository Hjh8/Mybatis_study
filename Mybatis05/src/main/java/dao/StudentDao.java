package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {
    // if标签
    List<Student> selectStudentIf(Student student);

    // where
    List<Student> selectStudentWhere(Student student);

    // foreach
    List<Student> selectStudentForeach(Student[] students);
}
