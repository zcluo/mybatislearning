package com.emmaluo.mybatislearning.IDAO;

import com.emmaluo.mybatislearning.model.Student;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * Created by zcluo on 2016/6/23.
 */
@Component
public interface StudentMapper {
    List<Student> findAllStudents(RowBounds rowBounds);
    List<Student> findAllStudents();
    List<Student> findAllStudentsByNameEmail(String name,String email);
    Student findStudentById(Integer id);
    int insertStudent(Student student);
    int insertStudentWithPhone(Student student);
    int insertStudentWithGender(Student student);
    int deleteStudentById(Integer id);
    Student selectStudentWithAddress(Integer studId);
    int updateStudent(Student student);

}
