package com.emmaluo.mybatislearning.service;

import com.emmaluo.mybatislearning.IDAO.StudentMapper;
import com.emmaluo.mybatislearning.IDAO.TutorMapper;
import com.emmaluo.mybatislearning.model.Tutor;
import com.emmaluo.mybatislearning.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zcluo on 2016/6/24.
 */
public class TutorService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public Tutor findTutorById(Integer tutorId){
        logger.debug("Select Tutor By ID :{}",tutorId);
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try{
            TutorMapper tutorMapper = sqlSession.getMapper(TutorMapper.class);
            return tutorMapper.findTutorById(tutorId);
        }
        finally {
            sqlSession.close();
        }
    }
}
