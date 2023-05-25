import com.demo.dao.BlogMapper;
import com.demo.entity.Blog;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

// 使用log4j的包

public class DaoTest {
    // 日志对象，参数对象为当前包的class
    static Logger logger = Logger.getLogger(DaoTest.class);


    @Test
    public void queryBlogById(){
        // 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = mapper.queryBlogById("a063555e7e6f4ef7a4fce73335e4af88");
        sqlSession.clearCache();
        Blog blog2 = mapper.queryBlogById("a063555e7e6f4ef7a4fce73335e4af88");

        System.out.println(blog);


        // 在一个session中两次记录是相同的
        /*
            映射语句文件中所有select语句结果都会被缓存。
            映射语句文件中所有insert、update和delete语句会刷新缓存
            缓存会使用最近最少使用的算法（LRU, Leaset Recently Used）算法来清除不需要的缓存。
            缓存不会定时进行刷新（也就是说，没有刷新间隔）。
            缓存会保存列表或对象的1024个引用。
            缓存会被视为读/写缓存，这意味着获取到的对象并不是共享的，可以安全地被调用者修改，而不干扰其他调用者或线程所做的潜在修改。
         */
        System.out.println(blog == blog2 ); // true // 增删改 会刷新缓存



        sqlSession.close();
    }

    @Test
    public  void cacheTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.queryBlogById("a063555e7e6f4ef7a4fce73335e4af88");
        System.out.println(blog);
        sqlSession.close();

        BlogMapper mapper2 = sqlSession2.getMapper(BlogMapper.class);
        Blog blog2 = mapper2.queryBlogById("a063555e7e6f4ef7a4fce73335e4af88");
        System.out.println(blog2);
        System.out.println(blog == blog2);
        sqlSession2.close();
    }
}
