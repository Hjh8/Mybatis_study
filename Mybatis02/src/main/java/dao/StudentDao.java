package dao;

import entity.Student;
import java.util.List;

public interface StudentDao {
    // 查询所有学生信息
    List<Student> selectStudents();
    // 插入学生信息
    int insertStudent(Student student);
}
