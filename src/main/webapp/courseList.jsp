<%@page import="student.mgmt.entities.Course"%>
<%@page import="student.mgmt.entities.Students"%>
<%@page import="java.util.List"%>
<%@page import="student.mgmt.dao.StudentDaoImpl"%>
<%@page import="student.mgmt.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course list</title>
<link rel="stylesheet" href="css/studentList.css">
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
<% StudentDao studentDao = new StudentDaoImpl();
List<Course>courseList = studentDao.getAllCourses();
%>
<nav id="navbar" class="nav">
    <img src="image/210166517-7f0f3ae2-62bf-4e07-9b7d-4f7c1f5099c8.png" alt="logo" class="logo">
     <a class="logout" href="logout">Logout</a>
  </nav>
  <h1>Course List</h1>
<table style="margin: auto;">

<tr>
<th>courseCode</th>
<th>courseName</th>
<th>CourseDescription</th>
<th>Action</th>
</tr>


<%for(Course course : courseList ){ %>

<tr>
<td><%= course.getCourseCode()%></td>
<td><%= course.getCourseName()%></td>
<td><%= course.getCourseDescription()%>
<a class="blue-btn" href="SubjectList.jsp?id=<%=course.getCourseCode()%>">Subject-List</a>
</td>
<td>

<a href="deletecourse?id=<%=course.getCourseCode()%>" id="red-btn">Delete</a>
</td>

</tr>


<% }%>


<tr>
<td colspan="10" style="text-align:center">
<a class ="blue-btn"href="addCourse.jsp">Add Course</a>
</td>
</tr>
</table>
<%@ include file="message.jsp" %>
<%} %>

</body>
</html>