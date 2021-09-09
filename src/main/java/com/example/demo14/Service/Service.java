package com.example.demo14.Service;

import java.util.List;

import com.example.demo14.Model.Student;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public interface Service {

    public Student save(Student student);

//    public List<Student> getStudents();

//    public Student getStudent(Long id);

    public List<Student> getStudent();
    public  List<Student> gtStudent();
    public List<Student>  getStudents(String name,String rollNumber);
    public List<Student>  gtStudents(String name,String rollNumber);
    public  List<Student>  notStudents(String name);
    public  List<Student>  greaterStudents(Long id);
    public  List<Student>  lessStudents(Long id);
    public  List<Student>  leStudents(Long id);
    public  List<Student>  geStudents(Long id);
    public List<Student> betweenStudents(Long id1, Long id2);
    public List<Student>  likeStudents();
    public  List<Student> ascStudents();





}
