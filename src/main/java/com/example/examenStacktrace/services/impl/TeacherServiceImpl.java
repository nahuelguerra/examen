package com.example.examenStacktrace.services.impl;

import com.example.examenStacktrace.models.Course;
import com.example.examenStacktrace.models.Teacher;
import com.example.examenStacktrace.repositories.TeacherRepository;
import com.example.examenStacktrace.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service(value = "teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public ResponseEntity<Collection<Teacher>> listTeachers() {
        return new ResponseEntity<>(teacherRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Teacher> findTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        if(teacher != null)
            return new ResponseEntity<>(teacherRepository.findById(id).orElseThrow(), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> saveTeacher(Teacher teacher) {
        return new ResponseEntity<>(teacherRepository.save(teacher), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Teacher> updateTeacher(Teacher teacher) {
        if (teacher.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!teacherRepository.existsById(teacher.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Teacher result = teacherRepository.save(teacher);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Course>> findCoursesOfTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        if(teacher != null)
            return new ResponseEntity<>(teacher.getCourses(), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
