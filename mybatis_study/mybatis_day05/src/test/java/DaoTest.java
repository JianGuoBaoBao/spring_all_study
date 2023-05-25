import com.demo.dao.BlogMapper;
import com.demo.entity.Blog;
import com.demo.utils.IDutils;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.*;

// 使用log4j的包

public class DaoTest {
    // 日志对象，参数对象为当前包的class
    static Logger logger = Logger.getLogger(DaoTest.class);

    @Test
    public void test() {

        // 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("demo哥");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);


        blog.setId(IDutils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("新测试中文语句");
        mapper.addBlog(blog);


        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void queryBlogIf() {
        // 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","Java如此简单");
        map.put("author","demo哥");

//        List<Blog> blogs = mapper.queryBlogIf(map);
        List<Blog> blogs = mapper.queryBlogChoose(map);

        for(Blog blog : blogs){
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        // 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","Java如此简单");
//        map.put("author","坚果宝宝");
        map.put("id","a063555e7e6f4ef7a4fce73335e4af88");

//        List<Blog> blogs = mapper.queryBlogIf(map);
        mapper.updateBlog(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        // 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper  mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("a063555e7e6f4ef7a4fce73335e4af88");
        ids.add("2af3432627f641fe860f43a06945da1b");

        // Cache cache =
        // 本地缓存

        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog:blogs
             ) {
            System.out.println(blog);
        }

        mapper.queryBlogForeach(map);
        sqlSession.close();
    }
}
