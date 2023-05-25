package com.demo.mapper;

import org.mybatis.spring.SqlSessionTemplate;

public class UserMapperImpl implements UserMapper{
    //我们所有操作，都使用sqlSession来执行，现在都是用SqlSessionTemplate;
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession){
        this.sqlSession = sqlSession;
    }

    public UserMapper getUserMapper() {
        return sqlSession.getMapper(UserMapper.class);
    }
}

