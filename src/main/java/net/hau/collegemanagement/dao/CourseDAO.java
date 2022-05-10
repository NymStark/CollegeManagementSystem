package net.hau.collegemanagement.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.hau.collegemanagement.model.Course;
import net.hau.collegemanagement.util.HibernateUtil;

public class CourseDAO {

/**
 * CRUD database operations
 *
 */

    public void saveCourse(Course course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Inside saveCourse: " + course.getName());
        	// start a transaction
            transaction = session.beginTransaction();
            // save the course object
            session.save(course);
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
     * Update course
     * @param course
     */
    public void updateCourse(Course course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the course object
            session.update(course); 
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
     * Delete course
     * @param id
     */
    public void deleteCourse(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a course object
            Course course = session.get(Course.class, id); //get course with given id
            if (course != null) {
                session.delete(course);
                System.out.println("Course is deleted");
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
     * Get course By ID
     * @param id
     * @return
     */
    public Course getCourse(int id) {

        Transaction transaction = null;
        Course course = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an course object
            course = session.get(Course.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return course;
    }

    /**
     * Get all courses
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Course > getAllCourse() {

        Transaction transaction = null;
        List < Course > listOfCourse = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Got a session inside CourseDAO.getAllCourse");
            
        	// start a transaction
            transaction = session.beginTransaction();
            // get an course object

            listOfCourse = session.createQuery("from Course").getResultList();
            System.out.println("After getting courses in getAllCourse");
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfCourse;
    }
}