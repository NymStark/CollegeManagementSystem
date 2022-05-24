<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="${request.getContextPath()}/include/header.jsp">
	<c:param name="title" value="Student Management" />
</c:import>

<body>
	<div class="container mtb">
		<div class="row">
			<center>
				<h1>Student Management</h1>
				<h2>
					<a href="new">Add New Student</a> &nbsp;&nbsp;&nbsp; <a href="list">List
						All Students</a>

				</h2>
			</center>
			<div align="center">
				<table border="1" cellpadding="5">
					<caption>
						<h2>List of Students</h2>
					</caption>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Department</th>
						<th>Year</th>
						<th>Semester</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="student" items="${listStudent}">
						<tr>
							<td><c:out value="${student.id}" /></td>
							<td><c:out value="${student.first_name}" /></td>
							<td><c:out value="${student.last_name}" /></td>
							<td><c:out value="${student.email}" /></td>
							<td><c:out value="${student.department}" /></td>
							<td><c:out value="${student.year}" /></td>
							<td><c:out value="${student.semester}" /></td>
							<td><a href="edit?id=<c:out value='${student.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
<c:import url="${request.getContextPath()}/include/footer.jsp" />