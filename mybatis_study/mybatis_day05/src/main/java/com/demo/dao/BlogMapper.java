package com.demo.dao;

import com.demo.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 插入数据
    int addBlog(Blog blog);

    // 查询博客
    List<Blog> queryBlogIf(Map map);


    List<Blog> queryBlogChoose(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogForeach(Map map);
}
