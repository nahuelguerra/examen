package com.example.examenStacktrace.controllers;

import com.example.examenStacktrace.models.Course;
import com.example.examenStacktrace.models.Student;
import com.example.examenStacktrace.models.Teacher;
import com.example.examenStacktrace.repositories.StudentRepository;
import com.example.examenStacktrace.repositories.TeacherRepository;
import com.example.examenStacktrace.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<?> listTeachers(){
        //recuperar y devolver la lista de libros
        try{
            return teacherService.listTeachers();
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findTeacher(@PathVariable Long id){
        try{
            return teacherService.findTeacher(id);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity<?> saveTeacher(@RequestBody Teacher teacher){
        try{
            return teacherService.saveTeacher(teacher);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping
    public ResponseEntity<?> updateTeacher(@RequestBody Teacher teacher){
        try{
            return teacherService.updateTeacher(teacher);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id){
        try{
            return teacherService.deleteTeacher(id);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}/courses")
    public ResponseEntity<?> findCoursesOfTeacher(@PathVariable Long id){
        try{
            return teacherService.findCoursesOfTeacher(id);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
