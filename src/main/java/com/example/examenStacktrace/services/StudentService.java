package com.example.examenStacktrace.services;

import com.example.examenStacktrace.models.Course;
import com.example.examenStacktrace.models.Student;
import org.springframework.http.ResponseEntity;

import java.util.Collection;


public interface StudentService {
    public ResponseEntity<Collection<Student>> listStudents();
    public ResponseEntity<Student> findStudent(Long id);
    public ResponseEntity<?> saveStudent(Student student);
    public ResponseEntity<Student> updateStudent(Student student);
    public ResponseEntity<Void> deleteStudent(Long id);
    public ResponseEntity<Collection<Course>> findCoursesOfStudent(Long id);
    public ResponseEntity<Collection<Course>> findApprovedCoursesOfStudent(Long id);
}
