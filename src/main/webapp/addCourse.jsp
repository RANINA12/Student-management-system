<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/singup.css">
<title>Course Addition Page</title>

</head>
<body style="background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('image/wallpaperflare.com_wallpaper (12).jpg')">
	<%

String username = (String)session.getAttribute("username");
String password = (String) session.getAttribute("password");

if(username==null) {
	response.sendRedirect("facultyLogin.jsp");
}else{%>
	<div class="signup-container">
		<h1>Add New Course</h1>
		<form action="addcourse" method="get">
		<label for="CourseCode">CourseCode:</label>
    <input type="number" id="CourseCode" name="CourseCode" required><br>
    <label for="Coursename">CourseName:</label>
    <input type="text" id="Coursename" name="CourseName" required><br>
    <label for="CourseDescription">CourseDescription:</label>
    <input type="text" id="CourseDescription" name="CourseDescription" required><br>
    
    <button type="submit">Add Course</button>
</form>
	</div>
	<%} %>
</body>
</html>