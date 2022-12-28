package com.example.examenStacktrace.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String duration;
    @NotNull
    private String summary;
    @NotNull
    private Integer approvalNote;

    @ManyToMany
    @JsonBackReference(value="students_courses")
    @JoinTable(name = "students_courses", joinColumns = @JoinColumn(name = "course_id",
            referencedColumnName = "course_id"), inverseJoinColumns =  @JoinColumn(name = "student_id",
            referencedColumnName = "student_id"))
    private Set<Student> students = new HashSet<>();
    @ManyToMany
    @JsonBackReference(value="students_coursesApproved")
    @JoinTable(name = "students_coursesApproved", joinColumns = @JoinColumn(name = "course_id",
            referencedColumnName = "course_id"), inverseJoinColumns =  @JoinColumn(name = "student_id",
            referencedColumnName = "student_id"))
    private Set<Student> studentsApproved = new HashSet<>();

    @ManyToMany
    @JsonBackReference(value="teachers_courses")
    @JoinTable(name = "teachers_courses", joinColumns = @JoinColumn(name = "course_id",
            referencedColumnName = "course_id"), inverseJoinColumns =  @JoinColumn(name = "teacher_id",
            referencedColumnName = "teacher_id"))
    private Set<Teacher> teachers = new HashSet<>();

    //constructores
    public Course() {
    }

    public Course(Long id, String name, String duration, String summary, Integer approvalNote, Set<Student> students, Set<Student> studentsApproved, Set<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.summary = summary;
        this.approvalNote = approvalNote;
        this.students = students;
        this.studentsApproved = studentsApproved;
        this.teachers = teachers;
    }

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getApprovalNote() {
        return approvalNote;
    }

    public void setApprovalNote(Integer approvalNote) {
        this.approvalNote = approvalNote;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Student> getStudentsApproved() {
        return studentsApproved;
    }

    public void setStudentsApproved(Set<Student> studentsApproved) {
        this.studentsApproved = studentsApproved;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}