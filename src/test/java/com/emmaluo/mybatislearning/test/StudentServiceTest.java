package com.emmaluo.mybatislearning.test;

import com.emmaluo.mybatislearning.model.Gender;
import com.emmaluo.mybatislearning.model.PhoneNumber;
import com.emmaluo.mybatislearning.model.Student;

import com.emmaluo.mybatislearning.service.StudentService;
import org.apache.ibatis.session.RowBounds;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;



/**
 * Created by zcluo on 2016/6/23.
 */
public class StudentServiceTest {



    private static StudentService studentService;
    @Before
    public void setUp() throws Exception {

        studentService = new StudentService();

    }

    @After
    public void tearDown() throws Exception {

        studentService = null;
    }

    @Test
    public void findAllStudents() throws Exception {

        List<Student> students = studentService.findAllStudents();
        Assert.assertNotNull(students);
        for(Student student : students){
            System.out.println(student);
        }

    }

    @Test
    public void findStudentsAllWithPagenation() throws Exception {

        int offset=0;
        int limits=2;
        List<Student> students = studentService.findStudentsAllWithPagenation(offset,limits);
        Assert.assertNotNull(students);
        Assert.assertTrue(students.size()<=limits);
        for(Student student : students){
            System.out.println(student);
        }
    }

    @Test
    public void findStudentById() throws Exception {

        Student student = studentService.findStudentById(1);
        Assert.assertNotNull(student);
        System.out.println(student);
    }

    @Test
    public void findStudentsWithNameAndEmail() throws Exception {

        List<Student> students = studentService.findStudentsWithNameAndEmail("student_3","student_3@gmail.com");
        Assert.assertNotNull(students);
        System.out.println(students);

    }

    @Test
    public void findStudentWithAddress() throws Exception {

        Student student = studentService.findStudentWithAddress(1);
        Assert.assertNotNull(student);
        System.out.println(student);

    }



    @Test
    public void createStudent() throws Exception {
        Student student = new Student();
        int id = 3;
        //student.setStudId(id);
        student.setName("student_"+id);
        student.setEmail("student_"+id+"@gmail.com");
        student.setDob(new Date());
        int rowInserted = studentService.createStudent(student);
        id = student.getStudId();
        Student newStudent = studentService.findStudentById(id);
        Assert.assertNotNull(newStudent);
        Assert.assertEquals(1,rowInserted);
        System.out.println(newStudent);
        studentService.deleteStudentById(id);

    }

    @Test
    public void insertStudentWithPhone() throws Exception {

        Student student = new Student();
        int id = 3;
        //student.setStudId(id);
        student.setName("student_"+id);
        student.setEmail("student_"+id+"@gmail.com");
        student.setDob(new Date());
        PhoneNumber phone = new PhoneNumber("123-123-1239");
        student.setPhone(phone);
        int rowInserted = studentService.insertStudentWithPhone(student);
        id = student.getStudId();
        Student newStudent = studentService.findStudentById(id);
        Assert.assertNotNull(newStudent);
        Assert.assertEquals(1,rowInserted);
        System.out.println(newStudent);
        studentService.deleteStudentById(id);
    }

    @Test
    public void insertStudentWithGender() throws Exception {

        Student student = new Student();
        int id = 3;
        //student.setStudId(id);
        student.setName("student_"+id);
        student.setEmail("student_"+id+"@gmail.com");
        student.setDob(new Date());
        PhoneNumber phone = new PhoneNumber("123-123-1239");
        student.setPhone(phone);
        Gender gender = Gender.FEMALE;
        student.setGender(gender);
        int rowInserted = studentService.insertStudentWithGender(student);
        id = student.getStudId();
        Student newStudent = studentService.findStudentById(id);
        Assert.assertNotNull(newStudent);
        Assert.assertEquals(1,rowInserted);
        System.out.println(newStudent);
        studentService.deleteStudentById(id);
    }

    @Test
    public void updateStudent() throws Exception {

        Student student = new Student();
        int id = 0;
        //student.setStudId(id);
        student.setName("student_"+id);
        student.setEmail("student_"+id+"@gmail.com");
        student.setDob(new Date());
        int rowInserted = studentService.createStudent(student);
        id = student.getStudId();
        student.setName("student_" + id);
        student.setEmail("student_"+id+"@gmail.com");
        int rowUpdated = studentService.updateStudent(student);
        Assert.assertEquals(1,rowUpdated);
        student = studentService.findStudentById(id);
        System.out.println(student);
        int rowDeleted = studentService.deleteStudentById(id);
        Assert.assertEquals(1,rowDeleted);

    }

    @Test
    public void deleteStudentById() throws Exception {
        Student student = new Student();
        int id = 3;
        //student.setStudId(id);
        student.setName("student_"+id);
        student.setEmail("student_"+id+"@gmail.com");
        student.setDob(new Date());
        studentService.createStudent(student);
        int rowdeleted = studentService.deleteStudentById(student.getStudId());
        Student s = studentService.findStudentById(student.getStudId());
        Assert.assertNull(s);
        Assert.assertEquals(1,rowdeleted);


    }



}