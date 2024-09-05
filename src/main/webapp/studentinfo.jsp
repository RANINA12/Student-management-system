<%@page import="java.sql.Date"%>
<%@page import="student.mgmt.entities.Students"%>
<%@page import="student.mgmt.dao.StudentDaoImpl"%>
<%@page import="student.mgmt.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/studentInfo.css">
<title>Student's Page</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
String username = (String)session.getAttribute("username");
Date password = (Date)session.getAttribute("password");


if(username==null) {
	response.sendRedirect("login.jsp");
}else{%>
 <%
	String enrollment_id = request.getParameter("id");
	StudentDao studentDao = new StudentDaoImpl();
	Students student = studentDao.fetchStudentDetails1(enrollment_id);
	%>
	<%
	if(student==null) {
		response.sendRedirect("login.jsp");
	}else{
	
	%>
	 <nav id="navbar" class="nav">
    <img src="image/210166517-7f0f3ae2-62bf-4e07-9b7d-4f7c1f5099c8.png" alt="logo" class="logo">
    <a class="logout" href="logout">Logout</a>
  </nav>
	<div>

		<h1 class="hi" >Student Profile</h1>
		
		<table class="table table-bordered" style="">

			<tr>
				<th>Enrollment NO:-</th>

				<td style="color: red;"><%=student.getenrollment_id()%></td>
			</tr>
			<tr>
				<th>Name:-</th>

				<td><%=student.getName()%></td>
			</tr>

			<tr>
				<th>Email</th>

				<td><%=student.getEmail()%></td>
			</tr>

			<tr>
				<th>Date of Birth</th>

				<td><%=student.getDate_Of_birth()%></td>
			</tr>

			<tr>
				<th >Mobile No.</th>

				<td><%=student.getMobile_no()%></td>
			</tr>
			<tr>
				<th>Address:-</th>

				<td><%=student.getAddress()%></td>
			</tr>

			<tr>
				<th>Gender</th>

				<td><%=student.getGender()%></td>
			</tr>
			<tr>
				<th>Branch:-</th>

				<td><%=student.getBranch()%></td>
			</tr>
		</table>
	</div>
	<div class="button1">
<a class ="btn"href="studentviewofCourseEnrolled.jsp?id=<%=student.getenrollment_id()%>">Course Enrolled</a>
</div>
<%} }%>
</body>
</html>