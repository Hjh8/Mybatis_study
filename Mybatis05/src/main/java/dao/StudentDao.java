package dao;

import entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    // if标签
    List<Student> selectStudentIf(Student student);

    // where
    List<Student> selectStudentWhere(Student student);

    // foreach
    List<Student> selectStudentForeach(Student[] students);

    // sql片段
    Student selectStudentSQL(@Param("id") int id);
}
