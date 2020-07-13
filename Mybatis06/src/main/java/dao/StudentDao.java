package dao;

import entity.Student;

public interface StudentDao {
    Student selectStudentByID(int id);

}
