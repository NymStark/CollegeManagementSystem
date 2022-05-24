<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="${request.getContextPath()}/include/header.jsp">
	<c:param name="title" value="Registration Management" />
</c:import>

<body>
	<div class="container mtb">
		<div class="row">
 <center>
  <h1>Registration Management</h1>
        <h2>
         <a href="new">Add New Registration</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Registrations</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Registrations</h2></caption>
            <tr>
                <th>Registration ID</th>
                <th>Student ID</th>
                <th>Course Abbreviation</th>
                <th>Semester</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="registration" items="${listRegistration}">
                <tr>
                    <td><c:out value="${registration.id}" /></td>
                    <td><c:out value="${registration.student_id}" /></td>
                    <td><c:out value="${registration.courseAbbreviation}" /></td>
                    <td><c:out value="${registration.semester}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${registration.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${registration.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
    	</div>
	</div>
</body>
<c:import url="${request.getContextPath()}/include/footer.jsp" />