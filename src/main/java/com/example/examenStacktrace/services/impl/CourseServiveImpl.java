package com.example.examenStacktrace.services.impl;

import com.example.examenStacktrace.models.Course;
import com.example.examenStacktrace.models.Student;
import com.example.examenStacktrace.repositories.CourseRepository;
import com.example.examenStacktrace.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service(value = "courseService")
public class CourseServiveImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public ResponseEntity<Collection<Course>> findAll() {
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Course> findCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow();
        if(course != null)
            return new ResponseEntity<>(courseRepository.findById(id).orElseThrow(), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Course> saveCourse(Course course) {
        return new ResponseEntity<>(courseRepository.save(course), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Course> updateCourse(Course course) {
        if (course.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!courseRepository.existsById(course.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Course result = courseRepository.save(course);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteCourse(Long id) {
        courseRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Student>> findStudentsOfCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow();
        if(course != null)
            return new ResponseEntity<>(course.getStudents(), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Collection<Student>> findApprovedStudentsOfCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow();
        if(course != null)
            return new ResponseEntity<>(course.getStudentsApproved(), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
