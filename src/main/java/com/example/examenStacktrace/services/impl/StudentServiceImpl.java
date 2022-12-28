package com.example.examenStacktrace.services.impl;

import com.example.examenStacktrace.models.Course;
import com.example.examenStacktrace.models.Student;
import com.example.examenStacktrace.repositories.StudentRepository;
import com.example.examenStacktrace.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service(value="studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public ResponseEntity<Collection<Student>> listStudents() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Student> findStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        if(student != null)
            return new ResponseEntity<>(studentRepository.findById(id).orElseThrow(), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> saveStudent(Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Student> updateStudent(Student student) {
        if (student.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!studentRepository.existsById(student.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Student result = studentRepository.save(student);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Course>> findCoursesOfStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        if(student != null)
            return new ResponseEntity<>(student.getCourses(), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Collection<Course>> findApprovedCoursesOfStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        if(student != null)
            return new ResponseEntity<>(student.getCoursesApproved(), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
