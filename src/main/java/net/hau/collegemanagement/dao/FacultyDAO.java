package net.hau.collegemanagement.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.hau.collegemanagement.model.Faculty;
import net.hau.collegemanagement.util.HibernateUtil;

public class FacultyDAO {

/**
 * CRUD database operations
 *
 */

    public void saveFaculty(Faculty faculty) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Inside saveFaculty: " + faculty.getFirst_name());
        	// start a transaction
            transaction = session.beginTransaction();
            // save the faculty object
            session.save(faculty);
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
     * Update faculty
     * @param faculty
     */
    public void updateFaculty(Faculty faculty) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the faculty object
            session.update(faculty); 
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
     * Delete faculty
     * @param id
     */
    public void deleteFaculty(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a faculty object
            Faculty faculty = session.get(Faculty.class, id); //get faculty with given id
            if (faculty != null) {
                session.delete(faculty);
                System.out.println("Faculty is deleted");
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
     * Get faculty By ID
     * @param id
     * @return
     */
    public Faculty getFaculty(int id) {

        Transaction transaction = null;
        Faculty faculty = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an faculty object
            faculty = session.get(Faculty.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return faculty;
    }

    /**
     * Get all facultys
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Faculty > getAllFaculty() {

        Transaction transaction = null;
        List < Faculty > listOfFaculty = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Got a session inside FacultyDAO.getAllFaculty");
            
        	// start a transaction
            transaction = session.beginTransaction();
            // get an faculty object

            listOfFaculty = session.createQuery("from Faculty").getResultList();
            System.out.println("After getting faculties in getAllFaculty");
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfFaculty;
    }
}