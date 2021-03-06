<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:import url="include/header.jsp">
	<c:param name="title" value="Working Page" />
</c:import>
<div class="container mtb">
	<div class="row">

			<body>
 <center>
  <h1>Course Management</h1>
        <h2>
         <a href="new">Add New Course</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Courses</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${course != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${course == null}">
   <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${course != null}">
               Edit Course
              </c:if>
              <c:if test="${course == null}">
               Add New Course
              </c:if>
             </h2>
            </caption>
          <c:if test="${course != null}">
           <input type="hidden" name="id" value="<c:out value='${course.id}' />" />
          </c:if>            
            <tr>
                <th>Course Name: </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${course.name}'/>"/>
                </td>
            </tr>
            
            <tr>
                <th>Course Department: </th>
                <td>
                 <input type="text" name="department" size="45"
                   value="<c:out value='${course.department}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Abbreviation: </th>
                <td>
                 <input type="text" name="courseAbbreviation" size="15"
                   value="<c:out value='${course.courseAbbreviation}' />"/>
                </td>
            </tr>
            <tr>
                <th>Semester: </th>
                <td>
                 <input type="text" name="semester" size="15"
                   value="<c:out value='${course.semester}' />"
                 />
                </td>
            </tr>
            
             <tr>
                <th>Maximum Student Capacity: </th>
                <td>
                 <input type="number" name="max_students" size="15"
                   value="<c:out value='${course.max_students}' />"
                 />
                </td>
            </tr>
            
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
		
		
	</div>
</div>


<c:import url="include/footer.jsp" />