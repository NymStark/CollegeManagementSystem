


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

import net.hau.collegemanagement.dao.StudentDAO;
import net.hau.collegemanagement.model.Student;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all requests from the student.
 */

@WebServlet(urlPatterns = {"/student/", "/student/list", "/student/new", "/student/insert", 
		"/student/delete", "/student/edit", "/student/update"})
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDao;

    public void init() {
        studentDao = new StudentDAO();
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
                case "/student/new":
                    showNewForm(request, response);
                    break;
                case "/student/insert":
                    insertStudent(request, response);
                    break;
                case "/student/delete":
                	deleteStudent(request, response);
                    break;
                case "/student/edit":
                    showEditForm(request, response);
                    break;
                case "/student/update":
                    updateStudent(request, response);
                    break;
                default:
                    listStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Student > listStudent = studentDao.getAllStudent();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDao.getStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);

    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        int year = Integer.parseInt(request.getParameter("year"));
        String semester = request.getParameter("semester");
        
        System.out.println("name="+first_name+ " "+last_name + " sem=" + semester);
        
        Student newStudent = new Student(first_name, last_name, email, department, year, semester);
        System.out.println("Inside StudentServlet.insertStudent: " + newStudent.getFirst_name());
        
        
    	// start a transaction
        studentDao.saveStudent(newStudent);
        response.sendRedirect("list");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        int year = Integer.parseInt(request.getParameter("year"));
        String semester = request.getParameter("semester");

        Student student = new Student(id,first_name, last_name, email, department, year, semester);
        studentDao.updateStudent(student);
        response.sendRedirect("list");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDao.deleteStudent(id);
        response.sendRedirect("list");
    }
}