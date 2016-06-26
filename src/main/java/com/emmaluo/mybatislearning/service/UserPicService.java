package com.emmaluo.mybatislearning.service;

import com.emmaluo.mybatislearning.IDAO.TutorMapper;
import com.emmaluo.mybatislearning.IDAO.UserPicMapper;
import com.emmaluo.mybatislearning.model.Tutor;
import com.emmaluo.mybatislearning.model.UserPic;
import com.emmaluo.mybatislearning.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zcluo on 2016/6/25.
 */
public class UserPicService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public int insertUserPic(UserPic userPic){
        logger.debug("Insert into User_Pics",userPic);
        int rowInserted = 0;
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try{
            UserPicMapper userPicMapper = sqlSession.getMapper(UserPicMapper.class);
            rowInserted = userPicMapper.insertUserPic(userPic);
            sqlSession.commit();
        }
        finally {
            sqlSession.close();
            return rowInserted;
        }
    }

    public UserPic getUserPic(Integer id){
        logger.debug("Select from User_Pics",id);
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try{
            UserPicMapper userPicMapper = sqlSession.getMapper(UserPicMapper.class);
            return userPicMapper.getUserPic(id);
        }
        finally {
            sqlSession.close();
        }
    }
}
