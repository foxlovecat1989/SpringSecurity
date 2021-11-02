package com.example.springsecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    private final List<Student> STUDENTS = List.of(
            new Student(1L, "James"),
            new Student(2L, "Mary"),
            new Student(3L, "Andy")
    );
    @GetMapping(path = "/{studentId}")
    public Student findById(@PathVariable("studentId") Long id){
        return STUDENTS.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student id:" + id + "DOES NOT EXISTS!"));
    }
}
