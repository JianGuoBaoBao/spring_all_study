import com.demo.dao.ParentDao;
import com.demo.dao.UserDao;
import com.demo.entity.Parent;
import com.demo.entity.User;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

// 使用log4j的包

public class DaoTest {
    // 日志对象，参数对象为当前包的class
    static Logger logger = Logger.getLogger(DaoTest.class);

    @Test
    public void test() {

        // 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ParentDao mapper = sqlSession.getMapper(ParentDao.class);

//        List<Parent> parentList = mapper.getParentByUserId();
        List<Parent> parentList = mapper.getParentByUserId2();
        for(Parent p : parentList){
            System.out.println(p);
        }


        sqlSession.close();

    }
}
