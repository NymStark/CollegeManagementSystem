package net.hau.collegemanagement.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.hau.collegemanagement.model.CourseAssignment;
import net.hau.collegemanagement.util.HibernateUtil;

public class CourseAssignmentDAO {

/**
 * CRUD database operations
 *
 */

    public void saveCourseAssignment(CourseAssignment courseAssignment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Inside saveCourseAssignment: " + courseAssignment.getFaculty_id());
        	// start a transaction
            transaction = session.beginTransaction();
            // save the courseAssignment object
            session.save(courseAssignment);
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
     * Update courseAssignment
     * @param courseAssignment
     */
    public void updateCourseAssignment(CourseAssignment courseAssignment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the courseAssignment object
            session.update(courseAssignment); 
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
     * Delete courseAssignment
     * @param id
     */
    public void deleteCourseAssignment(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a courseAssignment object
            CourseAssignment courseAssignment = session.get(CourseAssignment.class, id); //get courseAssignment with given id
            if (courseAssignment != null) {
                session.delete(courseAssignment);
                System.out.println("CourseAssignment is deleted");
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
     * Get courseAssignment By ID
     * @param id
     * @return
     */
    public CourseAssignment getCourseAssignment(int id) {

        Transaction transaction = null;
        CourseAssignment courseAssignment = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an courseAssignment object
            courseAssignment = session.get(CourseAssignment.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return courseAssignment;
    }

    /**
     * Get all courseAssignments
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < CourseAssignment > getAllCourseAssignment() {

        Transaction transaction = null;
        List < CourseAssignment > listOfCourseAssignment = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Got a session inside CourseAssignmentDAO.getAllCourseAssignment");
            
        	// start a transaction
            transaction = session.beginTransaction();
            // get an courseAssignment object

            listOfCourseAssignment = session.createQuery("from CourseAssignment").getResultList();
            System.out.println("After getting course assignments in getAllCourseAssignment");
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfCourseAssignment;
    }
}