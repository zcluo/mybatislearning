package com.emmaluo.mybatislearning.service;

import com.emmaluo.mybatislearning.IDAO.CourseMapper;

import com.emmaluo.mybatislearning.model.Course;
import com.emmaluo.mybatislearning.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by zcluo on 2016/6/24.
 */
public class CourseService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public List<Course> searchCourses(Map<String,Object> map){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            return courseMapper.searchCourses(map);
        }
        finally {
            sqlSession.close();
        }
    }
    public List<Course> searchCourses1(Map<String,Object> map){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            return courseMapper.searchCourses1(map);
        }
        finally {
            sqlSession.close();
        }
    }

    public List<Course> searchCoursesByTutors(Map<String,Object> map){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            return courseMapper.searchCoursesByTutors(map);
        }
        finally {
            sqlSession.close();
        }
    }
    public List<Course> searchCoursesByTutorsInClause(Map<String,Object> map){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            return courseMapper.searchCoursesByTutorsInClause(map);
        }
        finally {
            sqlSession.close();
        }
    }
}
