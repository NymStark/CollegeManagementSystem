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

import net.hau.collegemanagement.dao.FacultyDAO;
import net.hau.collegemanagement.model.Faculty;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all requests from the faculty.
 */

@WebServlet(urlPatterns = {"/faculty/", "/faculty/list", "/faculty/new", "/faculty/insert", 
		"/faculty/delete", "/faculty/edit", "/faculty/update"})
public class FacultyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FacultyDAO facultyDao;

    public void init() {
        facultyDao = new FacultyDAO();
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
                case "/faculty/new":
                    showNewForm(request, response);
                    break;
                case "/faculty/insert":
                    insertFaculty(request, response);
                    break;
                case "/faculty/delete":
                	deleteFaculty(request, response);
                    break;
                case "/faculty/edit":
                    showEditForm(request, response);
                    break;
                case "/faculty/update":
                    updateFaculty(request, response);
                    break;
                default:
                    listFaculty(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listFaculty(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Faculty > listFaculty = facultyDao.getAllFaculty();
        request.setAttribute("listFaculty", listFaculty);
        RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Faculty existingFaculty = facultyDao.getFaculty(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-form.jsp");
        request.setAttribute("faculty", existingFaculty);
        dispatcher.forward(request, response);

    }

    private void insertFaculty(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        
        System.out.println("name="+first_name+ " "+last_name + " email= " + email);
        
        Faculty newFaculty = new Faculty(first_name, last_name, email, department);
        System.out.println("Inside FacultyServlet.insertFaculty: " + newFaculty.getFirst_name());
        
        
    	// start a transaction
        facultyDao.saveFaculty(newFaculty);
        response.sendRedirect("list");
    }

    private void updateFaculty(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");

        Faculty faculty = new Faculty(id,first_name, last_name, email, department);
        facultyDao.updateFaculty(faculty);
        response.sendRedirect("list");
    }

    private void deleteFaculty(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        facultyDao.deleteFaculty(id);
        response.sendRedirect("list");
    }
}