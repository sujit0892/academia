package com.example.academia.JSON;

import com.example.academia.bean.Domain;

import java.util.Calendar;

public class CreateBill {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDomain() {
        return domain;
    }

    public void setDomain(Integer domain) {
        this.domain = domain;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Calendar getDeadline() {
        return deadline;
    }

    public void setDeadlinedate(Calendar deadlinedate) {
        this.deadline = deadlinedate;
    }

    private String description;
    private Integer domain;
    private String rollno;
    private Integer amount;
    private Calendar deadline;
}
