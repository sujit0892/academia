package com.example.academia.bean;

import javax.persistence.*;


@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    @Column(unique = true,nullable = false)
    private String roll_number;

    @Column(nullable = false)
    private String first_name;
    private String last_name;

    @Column(unique = true,nullable = false)
    private String email;

    private String photograph_path;
    @Column(columnDefinition="Decimal(10,2) default '0.0'",nullable = false)
    private float cgpa;
    @Column(nullable = false)
    private Integer total_credits;
    private Integer graduation_year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="domain_id")
    private Domain domain;

    private String specialization;
    private String placement_id;


    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(Integer total_credits) {
        this.total_credits = total_credits;
    }

    public Integer getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(Integer graduation_year) {
        this.graduation_year = graduation_year;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(String placement_id) {
        this.placement_id = placement_id;
    }
}
