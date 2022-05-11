<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Faculty Management Application</title>
</head>
<body>
 <center>
  <h1>Faculty Management</h1>
        <h2>
         <a href="new">Add New Faculty</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Faculties</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Faculties</h2></caption>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="faculty" items="${listFaculty}">
                <tr>
                    <td><c:out value="${faculty.id}"/></td>
                    <td><c:out value="${faculty.first_name}"/></td>
                    <td><c:out value="${faculty.last_name}"/></td>
                    <td><c:out value="${faculty.email}"/></td>
                    <td><c:out value="${faculty.department}"/></td>
                    <td>
                     <a href="edit?id=<c:out value='${faculty.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${faculty.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>