package com.example.academia.JSON;

import com.example.academia.bean.Bills;

import java.util.Calendar;

public class ViewBill {
    private Bills bill;
    private String roll_number;

    private int status;

    public ViewBill(Bills bill, String roll_number, int status) {
        this.bill = bill;
        this.roll_number = roll_number;

        this.status = status;
    }

    public Bills getBill() {
        return bill;
    }

    public void setBill(Bills bill) {
        this.bill = bill;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



}
