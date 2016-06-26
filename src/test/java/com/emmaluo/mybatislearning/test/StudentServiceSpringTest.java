package com.emmaluo.mybatislearning.test;

import com.emmaluo.mybatislearning.model.Address;
import com.emmaluo.mybatislearning.model.Student;
import com.emmaluo.mybatislearning.service.StudentService;
import com.emmaluo.mybatislearning.service.StudentServiceWithSpring;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by zcluo on 2016/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mybatis-spring.xml")
public class StudentServiceSpringTest {
    @Resource
    private StudentServiceWithSpring studentServiceWithSpring;

    @Test
    public void testCreateStudent(){
        Address address = new Address(0, "Quaker Ridge Rd.", "Bethel", "Brooklyn", "06801", "USA");
        Student stud = new Student();
        long ts = System.currentTimeMillis();
        stud.setName("stud_" + ts);
        stud.setEmail("stud_" + ts + "@gmail.com");
        stud.setAddress(address);
        Student student = studentServiceWithSpring.createStudent(stud);
        assertNotNull(student);
        assertEquals("stud_" + ts, student.getName());
        assertEquals("stud_" + ts + "@gmail.com", student.getEmail());
        System.err.println("CreatedStudent: " + student);
    }


}