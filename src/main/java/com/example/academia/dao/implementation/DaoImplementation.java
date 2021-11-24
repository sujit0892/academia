package com.example.academia.dao.implementation;

import com.example.academia.JSON.*;
import com.example.academia.bean.*;
import com.example.academia.dao.Dao;
import com.example.academia.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DaoImplementation  implements Dao{
    Session session =  SessionUtil.getSession();
    @Override
     public  Employee login(Employee emp) {

        try
        {
            Query query = session.createQuery("from Employee where email=:email and password=:password");
            query.setParameter("email", emp.getEmail());
            query.setParameter("password",emp.getPassword());
            Employee e=null;
            if(query.getResultList().size()==1)
                 e = (Employee) query.list().get(0);
            return e;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
        finally {
            session.close();
        }
        return new Employee();
    }

    @Override
    public int createBill(CreateBill bill) {
        try
        {
            if(bill.getRollno()!=null && bill.getDomain()==null)
            {

                    Query query = session.createQuery("from Student where roll_number=:roll_number");
                    query.setParameter("roll_number",bill.getRollno());
                    if(query.getResultList().size()==1)
                    {
                        Student s = (Student)(query.list().get(0));
                        Bills bill1 = new Bills();
                        bill1.setAmount(bill.getAmount());
                        bill1.setBill_date(Calendar.getInstance());
                        bill1.setDescription(bill.getDescription());
                        bill1.setDeadline(bill.getDeadline());
                        Transaction transaction = session.beginTransaction();
                        session.save(bill1);
                        Student_Bills st_bills  = new Student_Bills(s,bill1);
                        session.save(st_bills);
                        transaction.commit();
                        return bill1.getId();
                    }
                    else
                    {
                        return -1; //student id not found
                    }

                }
            else if (bill.getDomain()!=null && bill.getRollno()==null)
            {
                Domain domain = new Domain();
                session.load(domain,bill.getDomain());
                Query query = session.createQuery("from Student where domain=:domain");
                query.setParameter("domain",domain);
                if(query.getResultList().size()>0)
                {
                    Transaction transaction = session.beginTransaction();
                    for(int i=0;i<query.getResultList().size();i++)
                    {
                        Student s = (Student)(query.list().get(i));
                        Bills bill1 = new Bills();
                        bill1.setAmount(bill.getAmount());
                        bill1.setBill_date(Calendar.getInstance());
                        bill1.setDescription(bill.getDescription());
                        bill1.setDeadline(bill.getDeadline());
                        session.save(bill1);
                        Student_Bills st_bills  = new Student_Bills(s,bill1);
                        session.save(st_bills);
                    }

                    transaction.commit();
                    return 0;
                }
                else
                {
                    return -2; //domain not found
                }
            }

        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
        finally {
            session.close();
        }
        return -3; //server error
    }

    @Override
    public List<ViewBill> viewBill() {
        List<ViewBill> viewBills = new ArrayList<>();
        try
        {
            Query query = session.createQuery("from Bills ");
            List<Bills> bills = query.getResultList();
            if(bills.size()>0)
            {
                for(Bills b: bills)
                {
                    Query query1 = session.createQuery("from Student_Bills where bill=:bills");
                    query1.setParameter("bills",b);
                    if(query1.getResultList().size()!=0)
                    {
                        Student_Bills s = (Student_Bills) query1.getResultList().get(0);
                        Query query3 = session.createQuery("from Student_Payment where student=:st and bill=:bill");
                        query3.setParameter("st",s.getStudent());
                        query3.setParameter("bill",b);
                        viewBills.add(new ViewBill(b,s.getStudent().getRoll_number(),query3.getResultList().size()));


                    }
                }
            }
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
        finally {
            session.close();
        }
        return viewBills;
    }

    @Override
    public List<Bills> studentBill(String roll_number) {
        try
        {
            Query query = session.createQuery("from Student where roll_number=:roll_number");
            query.setParameter("roll_number",roll_number);
            if(query.getResultList().size()==1) {
                Student s = (Student) query.getResultList().get(0);
                Query query1= session.createQuery("from Student_Bills where student=:student");
                query1.setParameter("student",s);
                List<Student_Bills> student_bills = query1.getResultList();
                List<Bills> bills = new ArrayList<>();
                for(Student_Bills st:student_bills)
                {
                    bills.add(st.getBill());
                }
                return bills;

            }

        }catch(HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());

        }finally
        {
            session.close();
        }
        return null;
    }

    @Override
    public boolean deleteBill(List<BillId> ids) {
        try
        {
            boolean res = true;
            Transaction transaction = session.beginTransaction();

            for(BillId id:ids)
            {
                Bills bill = new Bills();
                session.load(bill,id.getBillId());
                if(bill!=null) {

                    Query query = session.createQuery("from Student_Bills where bill=:bill");
                    query.setParameter("bill", bill);
                    Student_Bills student_bills = (Student_Bills) query.getResultList().get(0);

                    Query query3 = session.createQuery("from Student_Payment where  bill=:bill");

                    query3.setParameter("bill", bill);
                    if (query3.getResultList().size() != 0) {
                        Student_Payment student_payment = (Student_Payment) query3.getResultList().get(0);
                        session.delete(student_payment);
                    }
                    session.delete(student_bills);
                    session.delete(bill);

                }
                else
                {
                    res &= false;
                }

            }
            transaction.commit();
            return res;

        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
        finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateAmount(UpdateAmount amt) {

        try
        {
            Transaction transaction = session.beginTransaction();
            Bills bill = new Bills();

            session.load(bill,amt.getId());
            if(bill!=null) {
                bill.setAmount(amt.getAmount());
                session.update(bill);
                transaction.commit();
                return true;
            }
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
        finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateDeadline(UpdateDeadline cal) {
        try
        {
            Transaction transaction = session.beginTransaction();
            Bills bill = new Bills();
            session.load(bill,cal.getId());
            if(bill!=null) {
                bill.setDeadline(cal.getDeadline());
                session.update(bill);
                transaction.commit();
                return true;
            }
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
        finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateDescription(UpdateDescription des) {
        try
        {
            Transaction transaction = session.beginTransaction();
            Bills bill = new Bills();
            session.load(bill,des.getId());
            if(bill!=null) {
                bill.setDescription(des.getDescription());
                session.update(bill);
                transaction.commit();
                return true;
            }
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
        finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Domain> getDomain() {
        try
        {
            Query query = session.createQuery("from Domain");
            List<Domain> domains = new ArrayList<>();
            for(Object domain:query.getResultList())
               domains.add((Domain) domain);
            return domains;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
        finally {
            session.close();
        }
        return null;
    }


}
