package com.demo.dao;

import com.demo.entity.Blog;
import org.apache.ibatis.annotations.Param;


public interface BlogMapper {
    Blog queryBlogById(@Param("id") String id);
    void updateBlogById(Blog blog);
}
