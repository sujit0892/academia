package com.example.academia.bean;

import javax.persistence.*;

@Entity
@Table(name="Student_Bills")
public class Student_Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="student_id")
    private Student student;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="bill_id",unique = true)
    private Bills bill;

    public Student_Bills()
    {

    }
    public Student_Bills(Student student, Bills bill) {
        this.student = student;
        this.bill = bill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Bills getBill() {
        return bill;
    }

    public void setBill(Bills bill) {
        this.bill = bill;
    }
}
