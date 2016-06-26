package com.emmaluo.mybatislearning.service;


import com.emmaluo.mybatislearning.IDAO.StudentMapper;
import com.emmaluo.mybatislearning.model.Student;

import com.emmaluo.mybatislearning.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zcluo on 2016/6/23.
 */
public class StudentService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public List<Student> findAllStudents(){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudents();
        }
        finally {
            sqlSession.close();
        }
    }

    public Student findStudentById(Integer studId){
        logger.debug("Select Student By ID :{}",studId);
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try{
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(studId);
        }
        finally {
            sqlSession.close();
        }
    }

    public Student findStudentWithAddress(Integer studId){
        logger.debug("Select Student By ID :{}",studId);
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try{
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.selectStudentWithAddress(studId);
        }
        finally {
            sqlSession.close();
        }
    }

    public List<Student> findStudentsWithNameAndEmail(String name,String email){
        logger.debug("Select Student by Name: {} and Email: {}",name,email);
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try{
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudentsByNameEmail(name,email);
        }
        finally {
            sqlSession.close();
        }
    }

    public List<Student> findStudentsAllWithPagenation(int offset,int limits){
        logger.debug("Select Student All with Pagenation!");
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            RowBounds rowBounds = new RowBounds(offset,limits);
            return studentMapper.findAllStudents(rowBounds);
        }
        finally {
            sqlSession.close();
        }
    }



    public int  createStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        int insertRows = 0;
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            insertRows = studentMapper.insertStudent(student);
            sqlSession.commit();

        } finally {
            sqlSession.close();
            return insertRows;
        }
    }

    public int insertStudentWithPhone(Student student){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        int insertRows = 0;
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            insertRows = studentMapper.insertStudentWithPhone(student);
            sqlSession.commit();

        } finally {
            sqlSession.close();
            return insertRows;
        }
    }

    public int insertStudentWithGender(Student student){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        int insertRows = 0;
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            insertRows = studentMapper.insertStudentWithGender(student);
            sqlSession.commit();

        } finally {
            sqlSession.close();
            return insertRows;
        }
    }

    public int deleteStudentById(Integer studId) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        int deleteRows = 0;
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            deleteRows = studentMapper.deleteStudentById(studId);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return deleteRows;
        }
    }

    public int updateStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        int updateRows = 0;
        try{
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            updateRows = studentMapper.updateStudent(student);
            sqlSession.commit();
        }
        finally {
            sqlSession.close();
            return updateRows;
        }
    }
}
