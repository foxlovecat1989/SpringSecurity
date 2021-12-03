package com.example.springsecurity.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/management/api/v1/students")
public class StudentManagementController {

    private final List<Student> STUDENTS = List.of(
            new Student(1L, "James"),
            new Student(2L, "Mary"),
            new Student(3L, "Andy")
    );
    //
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    @GetMapping(path = "/findAll")
    public List<Student> findAll(){
        return STUDENTS;
    }

    @PreAuthorize(value = "hasAnyAuthority('student:write')")
    @PostMapping
    public Student register(@RequestBody Student student){
        return student;
    }

    @PutMapping
    public Student update(@RequestBody Student student){
       return student;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id){
        System.out.println(id);
    }
}
