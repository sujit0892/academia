package com.example.academia.bean;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="Bills")
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar bill_date;

    @Temporal(TemporalType.DATE)
    private Calendar deadline;

    public Bills(String description, Integer amount, Calendar bill_date, Calendar deadline) {
        this.description = description;
        this.amount = amount;
        this.bill_date = bill_date;
        this.deadline = deadline;
    }

    public Bills() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Calendar getBill_date() {
        return bill_date;
    }

    public void setBill_date(Calendar bill_date) {
        this.bill_date = bill_date;
    }

    public Calendar getDeadline() {
        return deadline;
    }

    public void setDeadline(Calendar deadline) {
        this.deadline = deadline;
    }


}
