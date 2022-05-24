<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<c:import url="${request.getContextPath()}/include/header.jsp">
	<c:param name="title" value="Student Management" />
</c:import>
>
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
				<c:if test="${student != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="insert" method="post">
				</c:if>
				<table border="1" cellpadding="5">
					<caption>
						<h2>
							<c:if test="${student != null}">
               Edit Student
              </c:if>
							<c:if test="${student == null}">
               Add New Student
              </c:if>
						</h2>
					</caption>
					<c:if test="${student != null}">
						<input type="hidden" name="id"
							value="<c:out value='${student.id}' />" />
					</c:if>
					<tr>
						<th>Student First Name:</th>
						<td><input type="text" name="first_name" size="45"
							value="<c:out value='${student.first_name}' />" />
						</td>
					</tr>
					<tr>
						<th>Student Last Name:</th>
						<td><input type="text" name="last_name" size="45"
							value="<c:out value='${student.last_name}' />" />
						</td>
					</tr>
					<tr>
						<th>Student Email:</th>
						<td><input type="text" name="email" size="45"
							value="<c:out value='${student.email}' />" /></td>
					</tr>
					<tr>
						<th>Student Department:</th>
						<td><input type="text" name="department" size="45"
							value="<c:out value='${student.department}' />" />
						</td>
					</tr>
					<tr>
						<th>Student Year:</th>
						<td><input type="number" name="year" size="45"
							value="<c:out value='${student.year}' />" /></td>
					</tr>
					<tr>
						<th>Semester:</th>
						<td><input type="text" name="semester" size="15"
							value="<c:out value='${student.semester}' />" />
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save" /></td>
					</tr>
				</table>
				</form>
			</div>
		</div>
	</div>
</body>
<c:import url="${request.getContextPath()}/include/footer.jsp" />