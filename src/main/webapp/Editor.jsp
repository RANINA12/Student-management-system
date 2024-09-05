<%@page import="student.mgmt.entities.Faculty"%>
<%@page import="student.mgmt.dao.StudentDao"%>
<%@page import="student.mgmt.dao.StudentDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty Page</title>
<link rel="stylesheet" href="css/studentInfo.css">
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
String username = (String)session.getAttribute("username");
String password = (String) session.getAttribute("password");

if(username==null) {
	response.sendRedirect("facultyLogin.jsp");
}else{%>
	<%
	String code = request.getParameter("id");
	String name = request.getParameter("userName");
	try{
	Long computerCode = Long.parseLong(code);
	StudentDao studentDao = new StudentDaoImpl();
	Faculty faculty = studentDao.fetchFacultyDetails(name, computerCode);
	%>
	<%
	if(faculty==null) {
		response.sendRedirect("login.jsp");
	}else{
	
	%>
	
	<nav id="navbar" class="nav">
    <img src="image/210166517-7f0f3ae2-62bf-4e07-9b7d-4f7c1f5099c8.png" alt="logo" class="logo">
     <a class="logout" href="logout">Logout</a>
  </nav>
	<div>
		
		<h1 class="mb-0">Profile</h1>

		<table class="table table-bordered" style="">

			<tr>
				<th>Computer Code:-</th>

				<td><%=faculty.getComputerCode()%></td>
			</tr>
			<tr>
				<th>Name:-</th>

				<td><%=faculty.getName()%></td>
			</tr>

			<tr>
				<th>Email</th>

				<td><%=faculty.getEmail()%></td>
			</tr>

			<tr>
				<th>Date of Birth</th>

				<td><%=faculty.getDate_Of_birth()%></td>
			</tr>

			<tr>
				<th style="color: red;">Mobile No.</th>

				<td style="color: red;"><%=faculty.getMobile_no()%></td>
			</tr>
			<tr>
				<th>Address:-</th>

				<td><%=faculty.getAddress()%></td>
			</tr>

			<tr>
				<th>Gender</th>

				<td><%=faculty.getGender()%></td>
			</tr>
			<tr>
				<th>Branch:-</th>

				<td><%=faculty.getBranch()%></td>
			</tr>
		</table>
	</div>
	<div class="button">
	<a class ="btn"href="studentsList.jsp">Students List</a>
	<a class ="btn"href="courseList.jsp">Courses</a>
	<a class ="btn"href="login.jsp">Student Profile</a>
	</div>
	<%}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("error");
		response.sendRedirect("facultyLogin.jsp?message=Something went wrong please try again");
	}
	%>
	<%} %>
</body>
</html>