<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="${request.getContextPath()}/include/header.jsp">
	<c:param name="title" value="Course Assignment Management" />
</c:import>

<body>
	<div class="container mtb">
		<div class="row">
			<center>
				<h1>Course Assignment Management</h1>
				<h2>
					<a href="new">Add New Course Assignment</a> &nbsp;&nbsp;&nbsp; <a
						href="list">List All Course Assignments</a>

				</h2>
			</center>
			<div align="center">
				<c:if test="${courseAssignment != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${courseAssignment == null}">
					<form action="insert" method="post">
				</c:if>
				<table border="1" cellpadding="5">
					<caption>
						<h2>
							<c:if test="${courseAssignment != null}">
               Edit CourseAssignment
              </c:if>
							<c:if test="${courseAssignment == null}">
               Add New CourseAssignment
              </c:if>
						</h2>
					</caption>
					<c:if test="${courseAssignment != null}">
						<input type="hidden" name="id"
							value="<c:out value='${courseAssignment.id}' />" />
					</c:if>
					<tr>
						<th>Course ID:</th>
						<td><input type="text" name="course_id" size="45"
							value="<c:out value='${courseAssignment.course_id}' />" />
						</td>
					</tr>
					<tr>
						<th>Faculty ID:</th>
						<td><input type="text" name="faculty_id" size="45"
							value="<c:out value='${courseAssignment.faculty_id}' />" />
						</td>
					</tr>
					<tr>
						<th>CourseAssignment Semester:</th>
						<td><input type="text" name="semester" size="45"
							value="<c:out value='${courseAssignment.semester}' />" />
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