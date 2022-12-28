package com.example.examenStacktrace.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    private String phone;
    @NotNull
    private String address;
    private String gender;
    @NotNull
    private String typeDocument;
    @NotNull
    private String numDocument;
    @NotNull
    private LocalDate dateOfBirth ;
    private List<String> trainings;
    private List<String> titles;
    @ManyToMany
    @JsonBackReference(value = "teachers_courses")
    @JoinTable(name = "teachers_courses", joinColumns = @JoinColumn(name = "teacher_id",
            referencedColumnName = "teacher_id"), inverseJoinColumns =  @JoinColumn(name = "course_id",
            referencedColumnName = "course_id"))
    private Set<Course> courses = new HashSet<>();


    //constructores
    public Teacher() {
    }

    public Teacher(Long id, String firstname, String lastname, String phone, String address, String gender, String typeDocument, String numDocument, LocalDate dateOfBirth, List<String> trainings, List<String> titles, Set<Course> courses) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.typeDocument = typeDocument;
        this.numDocument = numDocument;
        this.dateOfBirth = dateOfBirth;
        this.trainings = trainings;
        this.titles = titles;
        this.courses = courses;
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

    public List<String> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<String> trainings) {
        this.trainings = trainings;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}