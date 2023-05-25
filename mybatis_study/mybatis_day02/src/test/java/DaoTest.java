import com.demo.dao.UserDao;
import com.demo.entity.User;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoTest {

    @Test
    public void test(){

        // 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 执行SQL
        try {
            // 方法一：getMapper
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();

            // 方法二：
            // List<User> userList = sqlSession.selectList("com.com.demo.dao.UserDao.getUserList");

            for(User user :userList){
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.getUserById(1);
        System.out.println(user);

        sqlSession.close();

    }


    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        userDao.addUser(new User(4,"user1",18));
        // 提交事务
        sqlSession.commit();


        sqlSession.close();
    }



    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.updateUser(new User(4, "hello", 34,"nv",1));


        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void del(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deleteUser(4);


        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
