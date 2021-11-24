package com.example.academia.JSON;

import java.util.Calendar;

public class UpdateDeadline {
    private Integer id;
    private Calendar deadline;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDeadline() {
        return deadline;
    }

    public void setDeadline(Calendar deadline) {
        this.deadline = deadline;
    }
}
