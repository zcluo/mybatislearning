package com.emmaluo.mybatislearning;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

/**
 * Created by zcluo on 2016/6/23.
 */
public class MainTest {

    public static void main(String[] args){

        String source = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(source);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);
            SqlSession session = factory.openSession();
            Connection connection = session.getConnection();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();


        }
        finally {

        }


    }
}
