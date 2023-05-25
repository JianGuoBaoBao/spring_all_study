package com.demo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try{
            // 使用Mybatis第一步：获取sqlSessionFactory
            String resource = "mybatis-config.xml";
            Reader reader = new InputStreamReader(getResourceAsStream(resource), "utf8");

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // 既然有了SqlSessionFactory, 顾名思义，我们就可以从中获取SqlSession的实力了。
    // SqlSession 完全包含了面向数据库执行SQL命令所需的所有方法。
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
