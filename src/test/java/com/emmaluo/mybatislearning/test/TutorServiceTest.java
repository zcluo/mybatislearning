package com.emmaluo.mybatislearning.test;

import com.emmaluo.mybatislearning.model.Student;
import com.emmaluo.mybatislearning.model.Tutor;
import com.emmaluo.mybatislearning.service.StudentService;
import com.emmaluo.mybatislearning.service.TutorService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zcluo on 2016/6/24.
 */
public class TutorServiceTest {
    private static TutorService tutorService;
    @Before
    public void setUp() throws Exception {

        tutorService = new TutorService();

    }

    @After
    public void tearDown() throws Exception {

        tutorService = null;
    }
    @Test
    public void findTutorById() throws Exception {

        Tutor tutor = tutorService.findTutorById(1);
        Assert.assertNotNull(tutor);
        System.out.println(tutor);
    }

}