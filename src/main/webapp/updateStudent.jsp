<%@page import="student.mgmt.entities.Students"%>
<%@page import="student.mgmt.dao.StudentDao"%>
<%@page import="student.mgmt.dao.StudentDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/singup.css">
<title>Update Page</title>

</head>
<body style="background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('image/wallpaperflare.com_wallpaper (12).jpg')">
<%

String username = (String)session.getAttribute("username");
String password = (String) session.getAttribute("password");

if(username==null) {
	response.sendRedirect("facultyLogin.jsp");
}else{%>
<%
String enrollment_id = request.getParameter("id");
StudentDao studentDao = new StudentDaoImpl();
Students student = studentDao.fetchStudentDetails1(enrollment_id);

%>
	<div class="signup-container">
		<h1>Update Student Information</h1>
		<form action="updateStudent" method="get">
		<label for="enrollment_id">enrollment_id:</label>
    <input type="text" id="enrollment_id" name="enrollment_id" required value="<%=student.getenrollment_id()%>"><br>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required value="<%=student.getName()%>"><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required value="<%=student.getEmail()%>"><br>
    <label for="ID">Date of Birth:</label>
    <input type="date" id="date_Of_birth" name="date_Of_birth" required value="<%=student.getDate_Of_birth()%>"><br>
    <label for="mobile_no">Mobile No:</label>
    <input type="number" id="mobile_no" name="mobile_no" required value="<%=student.getMobile_no()%>"><br>
    <label for="Address">Address:</label>
    <input type="text" id="Address" name="Address" required value="<%=student.getAddress()%>"><br>
    <label for="gender">Gender:</label>
    <p>Male:<input type="radio" id="gender" name="gender" value="male"<% if(student.getGender().equals("male")) { %> checked<%} %>></p>
    <p>Female:<input type="radio" id="gender" name="gender" value="female" <% if(student.getGender().equals("female")) { %> checked<%} %>></p>
    <p>Other:<input type="radio" id="gender" name="gender" value="other" <% if(student.getGender().equals("other")) { %> checked<%} %>></p><br>
    <label for="Branch">Branch:</label>
    <input type="text" id="Branch" name="Branch" required value="<%=student.getBranch()%>"><br>
    <button type="submit">Update</button>
</form>
	</div>
	<%} %>
</body>
</html>