import entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class HelloMybatis {

    public static void main(String[] args) throws IOException {
        // 使用mybatis
        // 1.定义mybatis主配置文件的名称，从类路径开始
        String config = "mybatis_conf.xml";
        // 2.读取配置文件
        InputStream in = Resources.getResourceAsStream(config);
        // 3.使用SqlSessionFactoryBuilder创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 4.从SqlSessionFactory中获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 5.指定要执行的sql语句标识. 映射文件中的namespace+"."+标签的id值
        String sqlId = "dao.StudentDao"+"."+"selectStudents";
        // 6.通过sqlId找到sql语句并执行
        List<Student> students = sqlSession.selectList(sqlId);
        // tips:如果你按照推荐的命名方式命名，则可以认为是指定执行哪个接口中的哪个方法
        // 7.输出结果
        students.forEach(stu -> System.out.println(stu));
        // 8.关闭SqlSession对象
        sqlSession.close();
    }
}
