package com.example.academia.service;

import com.example.academia.JSON.*;
import com.example.academia.bean.Bills;
import com.example.academia.bean.Domain;
import com.example.academia.bean.Employee;
import com.example.academia.dao.implementation.DaoImplementation;

import java.util.Calendar;
import java.util.List;

public class Service {
    DaoImplementation dao = new DaoImplementation();
    public Employee login(Employee emp)
    {
        return dao.login(emp);
    }

    public int createBill(CreateBill bill)
    {
        return dao.createBill(bill);
    }

    public List<Bills> studentBill(String roll_number){return dao.studentBill(roll_number);}

    public List<ViewBill> viewBill(){return dao.viewBill();}

    public boolean deleteBill(List<BillId> ids){return dao.deleteBill(ids);}

    public boolean updateAmount(UpdateAmount amt){return dao.updateAmount(amt);}
    public boolean updateDeadline(UpdateDeadline cal){return dao.updateDeadline(cal);}
    public boolean updateDescription(UpdateDescription desc){return dao.updateDescription(desc);}
    public List<Domain> getDomain(){return dao.getDomain();}
}
