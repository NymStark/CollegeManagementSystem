package net.hau.collegemanagement.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.hau.collegemanagement.model.Registration;
import net.hau.collegemanagement.util.HibernateUtil;

public class RegistrationDAO {

/**
 * CRUD database operations
 *
 */

    public void saveRegistration(Registration registration) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Inside saveRegistration: " + registration.getId());
        	// start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(registration);
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
     * Update registration
     * @param registration
     */
    public void updateRegistration(Registration registration) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(registration); 
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
     * Delete registration
     * @param id
     */
    public void deleteRegistration(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a registration object
            Registration registration = session.get(Registration.class, id); //get registration with given id
            if (registration != null) {
                session.delete(registration);
                System.out.println("Registration is deleted");
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
     * Get registration By ID
     * @param id
     * @return
     */
    public Registration getRegistration(int id) {

        Transaction transaction = null;
        Registration registration = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an registration object
            registration = session.get(Registration.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return registration;
    }

    /**
     * Get all registrations
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Registration > getAllRegistration() {

        Transaction transaction = null;
        List < Registration > listOfRegistration = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("Got a session inside RegistrationDAO.getAllRegistration");
            
        	// start a transaction
            transaction = session.beginTransaction();
            // get an registration object

            listOfRegistration = session.createQuery("from Registration").getResultList();
            System.out.println("After getting departmenst in getAllRegistration");
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfRegistration;
    }
}