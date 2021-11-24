package com.example.academia.utils;

import com.example.academia.bean.Domain;
import com.example.academia.bean.Employee;
import com.example.academia.bean.Student;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class SessionUtil {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            Employee employee = new Employee();
//            employee.setEmail("placement@iiitb.org");
//            employee.setFirst_name("accounts");
//            employee.setPassword("123");
//            Domain domain = new Domain();
//            domain.setBatch("2020");
//            domain.setCapacity("120");
//            domain.setProgram("Mtech");
//            Student student = new Student();
//            student.setEmail("xyz@iiitb.org");
//            student.setFirst_name("xyz");
//            student.setDomain(domain);
//            student.setCgpa(9.0f);
//            student.setGraduation_year(2022);
//            student.setLast_name("kuy");
//            student.setRoll_number("MT2020106");
//            student.setTotal_credits(64);
//
//
//
//            Transaction transaction = session.beginTransaction();
//            //session.save(employee);
//            session.save(domain);
//            session.save(student);
//            transaction.commit();
//
//        } catch (HibernateException exception) {
//            System.out.print(exception.getLocalizedMessage());
//
//        }
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
//    }
}