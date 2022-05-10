package net.hau.collegemanagement.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.hau.collegemanagement.model.Department;
import net.hau.collegemanagement.util.HibernateUtil;

public class DepartmentDAO {

/**
 * CRUD database operations
 *
 */

    public void saveDepartment(Department department) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Inside saveDepartment: " + department.getName());
        	// start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(department);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update department
     * @param department
     */
    public void updateDepartment(Department department) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(department); 
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete department
     * @param id
     */
    public void deleteDepartment(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a department object
            Department department = session.get(Department.class, id); //get department with given id
            if (department != null) {
                session.delete(department);
                System.out.println("Department is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get department By ID
     * @param id
     * @return
     */
    public Department getDepartment(int id) {

        Transaction transaction = null;
        Department department = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an department object
            department = session.get(Department.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return department;
    }

    /**
     * Get all departments
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Department > getAllDepartment() {

        Transaction transaction = null;
        List < Department > listOfDepartment = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Got a session inside DepartmentDAO.getAllDepartment");
            
        	// start a transaction
            transaction = session.beginTransaction();
            // get an department object

            listOfDepartment = session.createQuery("from Department").getResultList();
            System.out.println("After getting departmenst in getAllDepartment");
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfDepartment;
    }
}