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

import net.hau.collegemanagement.dao.CourseAssignmentDAO;
import net.hau.collegemanagement.model.CourseAssignment;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all requests from the courseAssignment.
 */

@WebServlet(urlPatterns = {"/courseAssignment/", "/courseAssignment/list", "/courseAssignment/new", "/courseAssignment/insert", 
		"/courseAssignment/delete", "/courseAssignment/edit", "/courseAssignment/update"})
public class CourseAssignmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseAssignmentDAO courseAssignmentDao;

    public void init() {
        courseAssignmentDao = new CourseAssignmentDAO();
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
                case "/courseAssignment/new":
                    showNewForm(request, response);
                    break;
                case "/courseAssignment/insert":
                    insertCourseAssignment(request, response);
                    break;
                case "/courseAssignment/delete":
                	deleteCourseAssignment(request, response);
                    break;
                case "/courseAssignment/edit":
                    showEditForm(request, response);
                    break;
                case "/courseAssignment/update":
                    updateCourseAssignment(request, response);
                    break;
                default:
                    listCourseAssignment(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCourseAssignment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < CourseAssignment > listCourseAssignment = courseAssignmentDao.getAllCourseAssignment();
        request.setAttribute("listCourseAssignment", listCourseAssignment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("courseAssignment-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("courseAssignment-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CourseAssignment existingCourseAssignment = courseAssignmentDao.getCourseAssignment(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("courseAssignment-form.jsp");
        request.setAttribute("courseAssignment", existingCourseAssignment);
        dispatcher.forward(request, response);

    }

    private void insertCourseAssignment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        int faculty_id = Integer.parseInt(request.getParameter("faculty_id"));
        String semester = request.getParameter("semester");
        
        System.out.println("course id="+course_id+ " faculty id "+faculty_id + " semester= " + semester);
        
        CourseAssignment newCourseAssignment = new CourseAssignment(course_id, faculty_id, semester);
        System.out.println("Inside CourseAssignmentServlet.insertCourseAssignment: " + newCourseAssignment.getCourse_id());
        
        
    	// start a transaction
        courseAssignmentDao.saveCourseAssignment(newCourseAssignment);
        response.sendRedirect("list");
    }

    private void updateCourseAssignment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        int faculty_id = Integer.parseInt(request.getParameter("faculty_id"));
        String semester = request.getParameter("semester");


        CourseAssignment courseAssignment = new CourseAssignment(id,course_id, faculty_id, semester);
        courseAssignmentDao.updateCourseAssignment(courseAssignment);
        response.sendRedirect("list");
    }

    private void deleteCourseAssignment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        courseAssignmentDao.deleteCourseAssignment(id);
        response.sendRedirect("list");
    }
}