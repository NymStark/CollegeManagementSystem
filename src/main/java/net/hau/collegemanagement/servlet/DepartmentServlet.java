


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

import net.hau.collegemanagement.dao.DepartmentDAO;
import net.hau.collegemanagement.model.Department;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all requests from the department.
 */

@WebServlet(urlPatterns = {"/department/", "/department/list", "/department/new", "/department/insert", 
		"/department/delete", "/department/edit", "/department/update"})
public class DepartmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DepartmentDAO departmentDao;

    public void init() {
        departmentDao = new DepartmentDAO();
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
                case "/department/new":
                    showNewForm(request, response);
                    break;
                case "/department/insert":
                    insertDepartment(request, response);
                    break;
                case "/department/delete":
                	deleteDepartment(request, response);
                    break;
                case "/department/edit":
                    showEditForm(request, response);
                    break;
                case "/department/update":
                    updateDepartment(request, response);
                    break;
                default:
                    listDepartment(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listDepartment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Department > listDepartment = departmentDao.getAllDepartment();
        request.setAttribute("listDepartment", listDepartment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("department-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("department-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Department existingDepartment = departmentDao.getDepartment(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("department-form.jsp");
        request.setAttribute("department", existingDepartment);
        dispatcher.forward(request, response);

    }

    private void insertDepartment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String name = request.getParameter("name");
        String semester = request.getParameter("semester");
        System.out.println("name="+name + " sem=" + semester);
        Department newDepartment = new Department(name, semester);
        System.out.println("Inside DepartmentServlet.insertDepartment: " + newDepartment.getName());
    	// start a transaction
        departmentDao.saveDepartment(newDepartment);
        response.sendRedirect("list");
    }

    private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String semester = request.getParameter("semester");

        Department department = new Department(id, name, semester);
        departmentDao.updateDepartment(department);
        response.sendRedirect("list");
    }

    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        departmentDao.deleteDepartment(id);
        response.sendRedirect("list");
    }
}