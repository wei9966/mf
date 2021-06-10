import com.wb.dao.IUserDao;
import com.wb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class AnnotationCRUDTest {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        is= Resources.getResourceAsStream("mybatis.xml");
        factory=new SqlSessionFactoryBuilder().build(is);
        session=factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception{
        session.commit();
        session.close();
        is.close();
    }

    @Test
    public void testSave(){
        User user=new User();
        user.setUsername("张三");
        user.setAddress("背景");
        user.setSex("男");
        userDao.saveUser(user);
    }

}
