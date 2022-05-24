<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="${request.getContextPath()}/include/header.jsp">
	<c:param name="title" value="Department Management" />
</c:import>

<body>
	<div class="container mtb">
		<div class="row">
			<center>
				<h1>Department Management</h1>
				<h2>
					<a href="new">Add New Department</a> &nbsp;&nbsp;&nbsp; <a
						href="list">List All Departments</a>

				</h2>
			</center>
			<div align="center">
				<c:if test="${department != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${department == null}">
					<form action="insert" method="post">
				</c:if>
				<table border="1" cellpadding="5">
					<caption>
						<h2>
							<c:if test="${department != null}">
               Edit Department
              </c:if>
							<c:if test="${department == null}">
               Add New Department
              </c:if>
						</h2>
					</caption>
					<c:if test="${department != null}">
						<input type="hidden" name="id"
							value="<c:out value='${department.id}' />" />
					</c:if>
					<tr>
						<th>Department Name:</th>
						<td><input type="text" name="name" size="45"
							value="<c:out value='${department.name}' />" />
						</td>
					</tr>

					<tr>
						<th>Abbreviation:</th>
						<td><input type="text" name="abbreviation" size="15"
							value="<c:out value='${department.abbreviation}' />" />
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							valueSystem.out.println("Got a session inside DepartmentDAO.getAllDepartment");
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