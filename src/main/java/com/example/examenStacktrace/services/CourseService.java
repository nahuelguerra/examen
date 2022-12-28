package com.example.examenStacktrace.services;

import com.example.examenStacktrace.models.Course;
import com.example.examenStacktrace.models.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Collection;

public interface CourseService {
    public ResponseEntity<Collection<Course>> findAll();
    public ResponseEntity<Course> findCourse(Long id);
    public ResponseEntity<Course> saveCourse(Course course);
    public ResponseEntity<Course> updateCourse(Course course);
    public ResponseEntity<Void> deleteCourse(Long id);
    public ResponseEntity<Collection<Student>> findStudentsOfCourse(Long id);
    public ResponseEntity<Collection<Student>> findApprovedStudentsOfCourse(Long id);

}
