package net.hau.collegemanagement.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.hau.collegemanagement.model.Student;
import net.hau.collegemanagement.util.HibernateUtil;

public class StudentDAO {

/**
 * CRUD database operations
 *
 */

    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Inside saveStudent: " + student.getFirst_name());
        	// start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
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
     * Update student
     * @param student
     */
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(student); 
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
     * Delete student
     * @param id
     */
    public void deleteStudent(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a student object
            Student student = session.get(Student.class, id); //get student with given id
            if (student != null) {
                session.delete(student);
                System.out.println("Student is deleted");
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
     * Get student By ID
     * @param id
     * @return
     */
    public Student getStudent(int id) {

        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object
            student = session.get(Student.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }

    /**
     * Get all students
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Student > getAllStudent() {

        Transaction transaction = null;
        List < Student > listOfStudent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Got a session inside StudentDAO.getAllStudent");
            
        	// start a transaction
            transaction = session.beginTransaction();
            // get an student object

            listOfStudent = session.createQuery("from Student").getResultList();
            System.out.println("After getting students in getAllStudent");
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfStudent;
    }
}