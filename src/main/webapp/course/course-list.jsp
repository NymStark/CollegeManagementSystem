<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Course Management Application</title>
</head>
<body>
 <center>
  <h1>Course Management</h1>
        <h2>
         <a href="new">Add New Course</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Courses</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Courses</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Department</th>
                <th>Semester</th>
                <th>Maximum Capacity</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="course" items="${listCourse}">
                <tr>
                    <td><c:out value="${course.id}"/></td>
                    <td><c:out value="${course.name}"/></td>
                    <td><c:out value="${course.department}"/></td>
                    <td><c:out value="${course.semester}"/></td>
                    <td><c:out value="${course.max_students}"/></td>
                    <td>
                     <a href="edit?id=<c:out value='${course.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${course.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>