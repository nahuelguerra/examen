package com.example.examenStacktrace.services;

import com.example.examenStacktrace.models.Course;
import com.example.examenStacktrace.models.Teacher;
import org.springframework.http.ResponseEntity;


import java.util.Collection;

public interface TeacherService {
    public ResponseEntity<Collection<Teacher>> listTeachers();
    public ResponseEntity<Teacher> findTeacher(Long id);
    public ResponseEntity<?> saveTeacher(Teacher teacher);
    public ResponseEntity<Teacher> updateTeacher(Teacher teacher);
    public ResponseEntity<Void> deleteTeacher(Long id);
    public ResponseEntity<Collection<Course>> findCoursesOfTeacher(Long id);

}
