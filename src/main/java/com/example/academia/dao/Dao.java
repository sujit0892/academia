package com.example.academia.dao;

import com.example.academia.JSON.*;
import com.example.academia.bean.Bills;
import com.example.academia.bean.Domain;
import com.example.academia.bean.Employee;
import org.hibernate.sql.Update;

import java.util.Calendar;
import java.util.List;

public interface Dao {
    Employee login(Employee emp);
    int createBill(CreateBill bill);
    List<ViewBill> viewBill();
    List<Bills> studentBill(String roll_number);
    boolean deleteBill(List<BillId> ids);
    boolean updateAmount(UpdateAmount amt);
    boolean updateDeadline(UpdateDeadline cal);
    boolean updateDescription(UpdateDescription des);

    List<Domain> getDomain();

}
