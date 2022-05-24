


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

import net.hau.collegemanagement.dao.RegistrationDAO;
import net.hau.collegemanagement.model.Registration;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all requests from the registration.
 */

@WebServlet(urlPatterns = {"/registration/", "/registration/list", "/registration/new", "/registration/insert", 
		"/registration/delete", "/registration/edit", "/registration/update"})
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegistrationDAO registrationDao;

    public void init() {
        registrationDao = new RegistrationDAO();
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
                case "/registration/new":
                    showNewForm(request, response);
                    break;
                case "/registration/insert":
                    insertRegistration(request, response);
                    break;
                case "/registration/delete":
                	deleteRegistration(request, response);
                    break;
                case "/registration/edit":
                    showEditForm(request, response);
                    break;
                case "/registration/update":
                    updateRegistration(request, response);
                    break;
                default:
                    listRegistration(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listRegistration(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Registration > listRegistration = registrationDao.getAllRegistration();
        request.setAttribute("listRegistration", listRegistration);
        RequestDispatcher dispatcher = request.getRequestDispatcher("registration-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("registration-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Registration existingRegistration = registrationDao.getRegistration(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("registration-form.jsp");
        request.setAttribute("registration", existingRegistration);
        dispatcher.forward(request, response);

    }

    private void insertRegistration(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String student_id = request.getParameter("student_id");
        String semester = request.getParameter("semester");
        String courseAbbreviation = request.getParameter("courseAbbreviation");
        System.out.println("student_id="+student_id + " sem=" + semester);
        Registration newRegistration = new Registration(student_id,courseAbbreviation, semester);
        System.out.println("Inside RegistrationServlet.insertRegistration: " + newRegistration.getStudent_id());
    	// start a transaction
        registrationDao.saveRegistration(newRegistration);
        response.sendRedirect("list");
    }

    private void updateRegistration(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String student_id = request.getParameter("student_id");
        String courseAbbreviation = request.getParameter("courseAbbreviation");
        String semester = request.getParameter("semester");

        Registration registration = new Registration(id, student_id,courseAbbreviation, semester);
        registrationDao.updateRegistration(registration);
        response.sendRedirect("list");
    }

    private void deleteRegistration(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        registrationDao.deleteRegistration(id);
        response.sendRedirect("list");
    }
}