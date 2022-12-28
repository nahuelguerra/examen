package com.example.examenStacktrace.repositories;

import com.example.examenStacktrace.models.Student;
import com.example.examenStacktrace.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}

