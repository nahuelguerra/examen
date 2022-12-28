package com.example.examenStacktrace.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;

    private String phone;
    private String address;
    private String gender;
    @NotNull
    private String typeDocument;
    @NotNull
    private String numDocument;
    @NotNull
    private LocalDate dateOfBirth ;
    @ManyToMany
    @JsonBackReference(value="students_courses")
    @JoinTable(name = "students_courses", joinColumns = @JoinColumn(name = "student_id",
            referencedColumnName = "student_id"), inverseJoinColumns =  @JoinColumn(name = "course_id",
            referencedColumnName = "course_id"))
    private Set<Course> courses = new HashSet<>();
    @ManyToMany
    @JsonBackReference(value="students_coursesApproved")
    @JoinTable(name = "students_coursesApproved", joinColumns = @JoinColumn(name = "student_id",
            referencedColumnName = "student_id"), inverseJoinColumns =  @JoinColumn(name = "course_id",
            referencedColumnName = "course_id"))
    private Set<Course> coursesApproved = new HashSet<>();

    //constructores

    public Student() {
    }

    public Student(Long id, String firstname, String lastname, String phone, String address, String gender, String typeDocument, String numDocument, LocalDate dateOfBirth, Set<Course> courses, Set<Course> coursesApproved) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.typeDocument = typeDocument;
        this.numDocument = numDocument;
        this.dateOfBirth = dateOfBirth;
        this.courses = courses;
        this.coursesApproved = coursesApproved;
    }

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getNumDocument() {
        return numDocument;
    }

    public void setNumDocument(String numDocument) {
        this.numDocument = numDocument;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Course> getCoursesApproved() {
        return coursesApproved;
    }

    public void setCoursesApproved(Set<Course> coursesApproved) {
        this.coursesApproved = coursesApproved;
    }
}

