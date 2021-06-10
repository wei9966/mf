import com.wb.dao.IUserDao;
import com.wb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis使用
     * @param args
     */
    public static void main(String[] args) throws Exception {
//        1.获取字节输入流
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
//        2.根据字节流构建sqlsessionFactor
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
//        3.根据sqlSessionFactor生产一个sqlsession
        SqlSession session = build.openSession();
//        4.使用sqlSession获取Dao代理对象
        IUserDao mapper = session.getMapper(IUserDao.class);
//        5.执行dao方法
        List<User> all = mapper.findAll();
        for(User user:all){
            System.out.println(user);
        }
//        6.释放资源
        session.close();
        is.close();

    }

}
