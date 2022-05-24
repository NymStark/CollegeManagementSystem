<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="${request.getContextPath()}/include/header.jsp">
	<c:param name="title" value="Registration Management" />
</c:import>

<body>
	<div class="container mtb">
		<div class="row">
			<center>
				<h1>Registration Management</h1>
				<h2>
					<a href="new">Add New Registration</a> &nbsp;&nbsp;&nbsp; <a
						href="list">List All Registrations</a>

				</h2>
			</center>
			<div align="center">
				<c:if test="${registration != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${registration == null}">
					<form action="insert" method="post">
				</c:if>
				<table border="1" cellpadding="5">
					<caption>
						<h2>
							<c:if test="${registration != null}">
               Edit Registration
              </c:if>
							<c:if test="${registration == null}">
               Add New Registration
              </c:if>
						</h2>
					</caption>
					<c:if test="${registration != null}">
						<input type="hidden" name="id"
							value="<c:out value='${registration.id}' />" />
					</c:if>
					<tr>
						<th>Student ID:</th>
						<td><input type="text" name="student_id" size="45"
							value="<c:out value='${registration.student_id}' />" />
						</td>
					</tr>

					<tr>
						<th>Course Abbreviation:</th>
						<td><input type="text" name="courseAbbreviation"
							size="45"
							value="<c:out value='${registration.courseAbbreviation}' />" />
						</td>
					</tr>

					<tr>
						<th>Semester:</th>
						<td><input type="text" name="semester" size="15"
							value="<c:out value='${registration.semester}' />" />
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							valueSystem.out.println("Got a session inside RegistrationDAO.getAllRegistration");
            "Save" />
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
	</div>
</body>
<c:import url="${request.getContextPath()}/include/footer.jsp" />