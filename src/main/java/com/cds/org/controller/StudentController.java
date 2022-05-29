package com.cds.org.controller;


import com.cds.org.dao.Studentdao;
import com.cds.org.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {


    @Autowired
    private Studentdao studentdao;


    @PostMapping("/student")
    public String save(@RequestBody Student student){
        studentdao.saveStudent(student);

        return "Saved successfully";

    }

    @GetMapping("/student")
    public List<Student> getAllStudents(){

        return studentdao.getStudents();

    }
}
