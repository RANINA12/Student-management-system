<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/Form.css">
<title>Subject Addition Page</title>
</head>
<body style="background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('image/wallpaperflare.com_wallpaper (12).jpg')">
	<%

String username = (String)session.getAttribute("username");
String password = (String) session.getAttribute("password");

if(username==null) {
	response.sendRedirect("facultyLogin.jsp");
}else{%>
<%
String code =request.getParameter("id");
long coursecode=Long.parseLong(code);
%>
	<div class="signup-container">
		<h1>Add New Subject</h1>
		<form action="addsubject" method="get">
		<label for="SubjectCode">SubjectCode:</label>
    <input type="number" id="SubjectCode" name="SubjectCode" required><br>
    <label for="SubjectName">SubjectName:</label>
    <input type="text" id="SubjectName" name="SubjectName" required><br>
    <label for="CourseCode">CourseCode:</label>
    <input type="number" id="CourseCode" value="<%=coursecode%>" name="CourseCode" required><br>
    
    <button type="submit">Add Course</button>
</form>
	</div>
	<%} %>
</body>
</html>