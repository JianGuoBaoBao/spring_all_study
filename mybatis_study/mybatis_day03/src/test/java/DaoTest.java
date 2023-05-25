import com.demo.dao.UserDao;
import com.demo.entity.User;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

// 使用log4j的包
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class DaoTest {
    // 日志对象，参数对象为当前包的class
    static  Logger logger =  Logger.getLogger(DaoTest.class);

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
    public void testLog4j(){
        logger.info("info:进入testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }


    /*sql分页*/
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        HashMap<String ,Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserByLimit(map);
        for(User user :userList){
            System.out.println(user);
        }
        sqlSession.close();

    }


    /*RowBounds分页*/
    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        List<User> userList = sqlSession.selectList("com.com.demo.dao.UserDao.getUserByRowBounds",null,new RowBounds(1,2));
        for (User user :userList){
            System.out.println(user);
        }
        sqlSession.close();
    }



}
