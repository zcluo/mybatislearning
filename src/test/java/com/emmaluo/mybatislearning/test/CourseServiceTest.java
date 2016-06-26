package com.emmaluo.mybatislearning.test;

import com.emmaluo.mybatislearning.model.Course;
import com.emmaluo.mybatislearning.service.CourseService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by zcluo on 2016/6/24.
 */
public class CourseServiceTest {



    private static CourseService courseService;
    @Before
    public void setUp() throws Exception {

        courseService = new CourseService();

    }

    @After
    public void tearDown() throws Exception {

        courseService = null;
    }
    @Test
    public void searchCourses() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("tutorId", 1);
        map.put("courseName", "%java%");
        map.put("startDate", new Date());
        List<Course> courses = courseService.searchCourses(map);

        Assert.assertNotNull(courses);
        for(Course course : courses){
            System.out.println(course);
        }

    }

    @Test
    public void searchCoursesByTutor() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        /*<choose>
        <when test="searchBy == 'Tutor'">
                WHERE TUTOR_ID = #{tutorId}
        </when>
        <when test="searchBy == 'CourseName'">
                where name like #{courseName}
        </when>
        <otherwise>
                where TUTOR start_date >= now()
                </otherwise>*/
        map.put("searchBy", "Tutor");
        map.put("tutorId",1);
        List<Course> courses = courseService.searchCourses1(map);

        Assert.assertNotNull(courses);
        for(Course course : courses){
            System.out.println(course);
        }

    }

    @Test
    public void searchCoursesByCourseName() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        /*<choose>
        <when test="searchBy == 'Tutor'">
                WHERE TUTOR_ID = #{tutorId}
        </when>
        <when test="searchBy == 'CourseName'">
                where name like #{courseName}
        </when>
        <otherwise>
                where TUTOR start_date >= now()
                </otherwise>*/
        map.put("searchBy", "CourseName");
        map.put("courseName","%JavaEE6%");
        List<Course> courses = courseService.searchCourses1(map);

        Assert.assertNotNull(courses);
        for(Course course : courses){
            System.out.println(course);
        }

    }

    @Test
    public void searchCoursesByOthers() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        /*<choose>
        <when test="searchBy == 'Tutor'">
                WHERE TUTOR_ID = #{tutorId}
        </when>
        <when test="searchBy == 'CourseName'">
                where name like #{courseName}
        </when>
        <otherwise>
                where TUTOR start_date >= now()
                </otherwise>*/
        //map.put("searchBy", "CourseName");
        map.put("endDate",new Date());
        List<Course> courses = courseService.searchCourses1(map);

        Assert.assertNotNull(courses);
        for(Course course : courses){
            System.out.println(course);
        }

    }

    @Test
    public void searchCoursesByTutors() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> tutorIds = new ArrayList<String>();
        //tutorIds.add("1");
        tutorIds.add("2");
        map.put("tutorIds",tutorIds);
        List<Course> courses = courseService.searchCoursesByTutors(map);
        Assert.assertNotNull(courses);
        for(Course course : courses){
            System.out.println(course);
        }

    }

    @Test
    public void searchCoursesByTutorsInClause() throws Exception {

        Map<String,Object> map = new HashMap<String,Object>();
        List<String> tutorIds = new ArrayList<String>();
        tutorIds.add("1");
        tutorIds.add("2");
        map.put("tutorIds",tutorIds);
        List<Course> courses = courseService.searchCoursesByTutorsInClause(map);
        Assert.assertNotNull(courses);
        for(Course course : courses){
            System.out.println(course);
        }
    }

}