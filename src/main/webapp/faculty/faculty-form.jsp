<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="${request.getContextPath()}/include/header.jsp">
	<c:param name="title" value="Faculty Management" />
</c:import>

<body>
	<div class="container mtb">
		<div class="row">
			<center>
				<h1>Faculty Management</h1>
				<h2>
					<a href="new">Add New Faculty</a> &nbsp;&nbsp;&nbsp; <a href="list">List
						All Faculties</a>

				</h2>
			</center>
			<div align="center">
				<c:if test="${faculty != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${faculty == null}">
					<form action="insert" method="post">
				</c:if>
				<table border="1" cellpadding="5">
					<caption>
						<h2>
							<c:if test="${faculty != null}">
               Edit Faculty
              </c:if>
							<c:if test="${faculty == null}">
               Add New Faculty
              </c:if>
						</h2>
					</caption>
					<c:if test="${faculty != null}">
						<input type="hidden" name="id"
							value="<c:out value='${faculty.id}' />" />
					</c:if>
					<tr>
						<th>Faculty First Name:</th>
						<td><input type="text" name="first_name" size="45"
							value="<c:out value='${faculty.first_name}' />" />
						</td>
					</tr>
					<tr>
						<th>Faculty Last Name:</th>
						<td><input type="text" name="last_name" size="45"
							value="<c:out value='${faculty.last_name}' />" />
						</td>
					</tr>
					<tr>
						<th>Faculty Email:</th>
						<td><input type="text" name="email" size="45"
							value="<c:out value='${faculty.email}' />" /></td>
					</tr>
					<tr>
						<th>Faculty Department:</th>
						<td><input type="text" name="department" size="45"
							value="<c:out value='${faculty.department}' />" />
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