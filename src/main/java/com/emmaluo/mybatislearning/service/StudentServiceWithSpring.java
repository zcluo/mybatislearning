package com.emmaluo.mybatislearning.service;

import com.emmaluo.mybatislearning.IDAO.StudentMapper;
import com.emmaluo.mybatislearning.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by zcluo on 2016/6/26.
 */
@Component
public class StudentServiceWithSpring {
    @Resource
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Student createStudent(Student student)
    {
        this.studentMapper.insertStudent(student);
        return student;
    }
}
