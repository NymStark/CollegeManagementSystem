package net.hau.collegemanagement.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import net.hau.collegemanagement.model.*;

/**
 * Java based configuration
 * @author ramesh Fadatare
 *
 */
public class HibernateUtil {
 private static SessionFactory sessionFactory;

 public static SessionFactory getSessionFactory() {
  if (sessionFactory == null) {
   try {
    Configuration configuration = new Configuration();

    // Hibernate settings equivalent to hibernate.cfg.xml's properties
    Properties settings = new Properties();
    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/college_management?useSSL=false");
    settings.put(Environment.USER, "root");
    settings.put(Environment.PASS, "hau1986.");
    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

    settings.put(Environment.SHOW_SQL, "true");//very useful for debugging - shows the SQL code

    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

   // settings.put(Environment.HBM2DDL_AUTO, "create-drop");
    settings.put(Environment.HBM2DDL_AUTO, "update");

    configuration.setProperties(settings);
    configuration.addAnnotatedClass(Student.class); //to work with the User table/class, we need to register here. 
    configuration.addAnnotatedClass(Department.class);
    configuration.addAnnotatedClass(Faculty.class);
    configuration.addAnnotatedClass(Course.class);
    configuration.addAnnotatedClass(Registration.class);
    configuration.addAnnotatedClass(CourseAssignment.class);
    
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
      .applySettings(configuration.getProperties()).build();
    System.out.println("Hibernate Java Config serviceRegistry created");
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    return sessionFactory;

   } catch (Exception e) {
    e.printStackTrace();
   }
  }
  return sessionFactory;
 }
}