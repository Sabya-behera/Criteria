package com.example.demo14.Controller;

import java.util.List;

import com.example.demo14.Model.Student;
import com.example.demo14.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/post")
    public Student createStudent(@RequestBody Student student) //save
     {
        Student createResponse = studentService.save(student);
        return createResponse;
    }

    @GetMapping("/get")
    public List<Student> getStudents() {
        List<Student> getResponse = studentService.getStudents();
        return getResponse;
    }

    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable(value = "id")long id)
    {
        return (Student) studentService.getStudent(id);
    }
    @GetMapping("/gt/{id}")
    public  List<Student> gtStudent(@PathVariable(value = "id") long id)
    {
        return studentService.gtStudent(id);
    }

    @GetMapping("/getor/{name}/{rollNumber}")
    public  List<Student> getStudents(@PathVariable(value = "name")String name,@PathVariable(value = "rollNumber")String rollNumber)
    {
        return studentService.getStudents(name,rollNumber);
    }

    @GetMapping("/getand/{name}/{rollNumber}")
    public  List<Student> gtStudents(@PathVariable(value = "name")String name,@PathVariable(value = "rollNumber")String rollNumber)
    {
        return studentService.gtStudents(name,rollNumber);
    }

    @GetMapping("/getnot/{name}")
    public  List<Student> notStudents(@PathVariable(value = "name")String name)
    {
        return studentService.notStudents(name);
    }

    @GetMapping("/get>/{id}")
    public  List<Student> greaterStudents(@PathVariable(value = "id")long id)
    {
        return studentService.greaterStudents(id);
    }

    @GetMapping("/get</{id}")
    public  List<Student> lessStudents(@PathVariable(value = "id")long id)
    {
        return studentService.lessStudents(id);
    }

    @GetMapping("/get<=/{id}")
    public  List<Student> leStudents(@PathVariable(value = "id")long id)
    {
        return studentService.leStudents(id);
    }
    @GetMapping("/get>=/{id}")
    public  List<Student> geStudents(@PathVariable(value = "id")long id)
    {
        return studentService.geStudents(id);
    }

    @GetMapping("/getbetween/{id1}/{id2}")
    public List<Student> betweenStudents(@PathVariable(value = "id1") Long id1, @PathVariable(value = "id2") Long id2)
    {
        return studentService.betweenStudents(id1,id2);
    }



    @GetMapping("/getasc")
    public  List<Student> ascStudents()
    {
        return studentService.ascStudents();
    }


}