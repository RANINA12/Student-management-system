<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/Form.css">
<title>Student Enrollment Page</title>
</head>
<body style="background-image:url('image/wallpaperflare.com_wallpaper (12).jpg')">
	<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
String username = (String)session.getAttribute("username");
String password = (String) session.getAttribute("password");

if(username==null) {
	response.sendRedirect("facultyLogin.jsp");
}else{%>
<%String enrollment_id = request.getParameter("id"); %>
	<div class="signup-container">
		<h1>Enroll Student</h1>
		<form action="enrollstudent" method="get">
		
    <label for="EnrollmentID">EnrollmentID:</label>
    <input type="text" id="EnrollmentID" name="EnrollmentID" value="<%=enrollment_id%>" required><br>
    <label for="CourseCode">CourseCode:</label>
    <input type="number" id="CourseCode" name="CourseCode" required><br>
    <label for="EnrollmentDate">EnrollmentDate:</label>
    <input type="Date" id="EnrollmentDate" name="EnrollmentDate" required><br>
    
    <button type="submit">Enroll</button>
</form>
	</div>
	<%} %>
</body>
</html>