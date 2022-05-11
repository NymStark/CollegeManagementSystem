<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Department Management Application</title>
</head>
<body>
 <center>
  <h1>Department Management</h1>
        <h2>
         <a href="new">Add New Department</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Departments</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Departments</h2></caption>
            <tr>
                <th>Department ID</th>
                <th>Department Name</th>
                <th>Abbreviation</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="department" items="${listDepartment}">
                <tr>
                    <td><c:out value="${department.id}" /></td>
                    <td><c:out value="${department.name}" /></td>
                    <td><c:out value="${department.abbreviation}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${department.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${department.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>