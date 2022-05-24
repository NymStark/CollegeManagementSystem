package net.hau.collegemanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hau.collegemanagement.dao.CourseDAO;
import net.hau.collegemanagement.model.Course;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all requests from the course.
 */

@WebServlet(urlPatterns = {"/course/","/course/list", "/course/new", "/course/insert", 
		"/course/delete", "/course/edit", "/course/update"})
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseDAO courseDao;

    public void init() {
        courseDao = new CourseDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println("Inside doGet: action=" + action);

        try {
            switch (action) {
                case "/course/new":
                    showNewForm(request, response);
                    break;
                case "/course/insert":
                    insertCourse(request, response);
                    break;
                case "/course/delete":
                	deleteCourse(request, response);
                    break;
                case "/course/edit":
                    showEditForm(request, response);
                    break;
                case "/course/update":
                    updateCourse(request, response);
                    break;
                default:
                    listCourse(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCourse(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Course > listCourse = courseDao.getAllCourse();
        request.setAttribute("listCourse", listCourse);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Course existingCourse = courseDao.getCourse(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-form.jsp");
        request.setAttribute("course", existingCourse);
        dispatcher.forward(request, response);

    }

    private void insertCourse(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String courseAbbreviation = request.getParameter("courseAbbreviation");
        String semester = request.getParameter("semester");
        int max_students = Integer.parseInt(request.getParameter("max_students"));
        
        System.out.println("max students=" + max_students + " sem=" + semester);
        
        Course newCourse = new Course(name, department, courseAbbreviation, semester, max_students);
        System.out.println("Inside CourseServlet.insertCourse: " + newCourse.getName());
        
        
    	// start a transaction
        courseDao.saveCourse(newCourse);
        response.sendRedirect("list");
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String courseAbbreviation = request.getParameter("courseAbbreviation");
        String semester = request.getParameter("semester");
        int max_students = Integer.parseInt(request.getParameter("max_students"));

        Course course = new Course(id, name, department, courseAbbreviation, semester, max_students);
        courseDao.updateCourse(course);
        response.sendRedirect("list");
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        courseDao.deleteCourse(id);
        response.sendRedirect("list");
    }
}