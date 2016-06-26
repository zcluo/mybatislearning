package com.emmaluo.mybatislearning.IDAO;

import com.emmaluo.mybatislearning.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by zcluo on 2016/6/24.
 */
@Component
public interface CourseMapper {

    List<Course> searchCourses(Map<String,Object> map);
    List<Course> searchCourses1(Map<String,Object> map);
    List<Course> searchCoursesByTutors(Map<String,Object> map);
    List<Course> searchCoursesByTutorsInClause(Map<String,Object> map);
}
