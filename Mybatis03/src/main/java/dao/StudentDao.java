package dao;

import entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    // 一个简单类型的参数
    Student selectByID(int id);

    // 多个参数--@Param("")传值
    List<Student> selectMultiByParam(@Param("myname") String name,
                                     @Param("myage") int age);

    // 多个参数--对象传值
    List<Student> selectMultiByObj(Student student);

    // 多个参数--按位置(少用)
    List<Student> selectMultiByPosition(String name, int id);

    // 多个参数--Map传参（少用）
    List<Student> selectMultiByMap(Map<String, Object> map);
}
