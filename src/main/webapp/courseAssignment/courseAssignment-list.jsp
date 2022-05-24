<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="${request.getContextPath()}/include/header.jsp">
	<c:param name="title" value="Course Assignment Management" />
</c:import>

<body>
	<div class="container mtb">
		<div class="row">
 <center>
  <h1>CourseAssignment Management</h1>
        <h2>
         <a href="new">Add New CourseAssignment</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Faculties</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Faculties</h2></caption>
            <tr>
                <th>ID</th>
                <th>Course ID</th>
                <th>Faculty ID</th>
                <th>Semester</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="courseAssignment" items="${listCourseAssignment}">
                <tr>
                    <td><c:out value="${courseAssignment.id}"/></td>
                    <td><c:out value="${courseAssignment.course_id}"/></td>
                    <td><c:out value="${courseAssignment.faculty_id}"/></td>
                    <td><c:out value="${courseAssignment.semester}"/></td>
                    <td>
                     <a href="edit?id=<c:out value='${courseAssignment.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${courseAssignment.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
		</div>
	</div>
</body>
<c:import url="${request.getContextPath()}/include/footer.jsp" />