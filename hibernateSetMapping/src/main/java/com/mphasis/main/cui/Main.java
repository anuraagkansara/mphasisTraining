package com.mphasis.main.cui;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.mphasis.entities.Certificates;
import com.mphasis.entities.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sun.security.x509.CertificateSerialNumber;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {

    private static SessionFactory factory;

    public static void main(String[] args){
        try {
            factory = new Configuration().configure().buildSessionFactory();

            /* Let us have a set of certificates for the first employee  */
            HashSet set1 = new HashSet();
            set1.add(new Certificates("MCA"));
            set1.add(new Certificates("MBA"));
            set1.add(new Certificates("PMP"));
            /* Add few employee records in database */
            Main ME = new Main();
            Integer empID1 = ME.addEmployee("Zara", "Ali", 1000, set1);

            HashSet set2 = new HashSet();
            set2.add(new Certificates("BCA"));
            set2.add(new Certificates("BA"));

            /* Add another employee record in the database */
            Integer empID2 = ME.addEmployee("Dilip", "Kumar", 3000, set2);
//
            System.out.println("-----------------------");
            System.out.println(empID1);
            System.out.println(empID2);
//            System.out.println(empID3);
            System.out.println("------------------------");

//            ME.listEmployees();
//            ME.updateEmployee(1,76340);
            ME.listEmployees();
//            ME.deleteEmployee(1);
//            ME.listEmployees();

            System.out.println("--------------------------------");
            hqlLanguage();
            System.out.println("--------------------------------");


        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }
    public static void hqlLanguage(){

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            String hql = "FROM Employee";
            Query query = session.createQuery(hql);
            List results = query.list();
            results.forEach(System.out::println);

            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    /* Method to CREATE an employee in the database */
    public Integer addEmployee(String fname, String lname, int salary, HashSet cert){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employee.setCertificates(cert);

            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    /* Method to  READ all the employees */
    public void listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();){
                Employee employee = (Employee) iterator1.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
                Set certificates = employee.getCertificates();
                for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();){
                    Certificates certName = (Certificates) iterator2.next();
                    System.out.println("Certificate: " + certName.getName());
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE salary for an employee */
    public void updateEmployee(Integer EmployeeID, int salary ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
