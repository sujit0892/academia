package com.example.academia.bean;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="Student_Payment")
public class Student_Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;

    private String description;

    @Column(nullable = false)
    private Integer Amount;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar payment_date;

    @OneToOne()
    @JoinColumn(name="bill_id",unique = true)
    private Bills bill;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Calendar getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Calendar payment_date) {
        this.payment_date = payment_date;
    }
}
