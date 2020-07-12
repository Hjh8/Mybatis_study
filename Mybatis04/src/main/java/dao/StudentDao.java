package dao;

import entity.Student;
import java.util.Map;

public interface StudentDao {
    // resultType要求属性名跟列名一致
    Student selectStudentName(int id);

    //  使用typeAlias方式给类型取别名
    Student selectStudentAlias(int id);

    // 使用package方式给类型取别名
    Student selectStudentPackage(int id);

    // 返回类型为Map
    Map<Object,Object> selectStudentToMap(int id);

    // 使用resultMap
    Student selectStudentResultMap(int id);
}
