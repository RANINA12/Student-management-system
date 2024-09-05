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
<title>Student list</title>
<link rel="stylesheet" href="css/studentList.css">
</head>
<body>
<%

String username = (String)session.getAttribute("username");
String password = (String) session.getAttribute("password");

if(username==null) {
	response.sendRedirect("facultyLogin.jsp");
}else{%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
StudentDao studentDao = new StudentDaoImpl();
List<Students>studentList = studentDao.getAllStudents();
%>
<nav id="navbar" class="nav">
    <img src="image/210166517-7f0f3ae2-62bf-4e07-9b7d-4f7c1f5099c8.png" alt="logo" class="logo">
     <a class="logout" href="logout">Logout</a>
  </nav>
  <h1>Student List</h1>
<table class="student-table">

<tr>
<th>Enrollment_id</th>
<th>Name</th>
<th>Date of Birth</th>
<th>Email</th>
<th>Mobile_no</th>
<th>Address</th>
<th>Gender</th>
<th>Branch</th>
<th>Course</th>
<th>Action</th>
</tr>


<%for(Students student : studentList ){ %>

<tr>
<td><%= student.getenrollment_id()%></td>
<td><%= student.getName()%></td>
<td><%= student.getDate_Of_birth()%></td>
<td><%= student.getEmail()%></td>
<td><%= student.getMobile_no()%></td>
<td><%= student.getAddress()%></td>
<td><%= student.getGender()%></td>
<td><%= student.getBranch()%></td>
<td class="Enrolled">
<a class ="blue-btn"href="courseEnrolled.jsp?id=<%=student.getenrollment_id()%>">Course_Enrolled</a>
</td>
<td>
<p><a class ="blue-btn"href="updateStudent.jsp?id=<%=student.getenrollment_id()%>">Update</a><a href="deleteStudent?id=<%=student.getenrollment_id()%>" id="red-btn">Delete</a></p>

</td>

</tr>


<% }%>


<tr>
<td colspan="10" style="text-align:center">
<a class ="blue-btn"href="signup.jsp">Add Student</a>
</td>
</tr>
</table>
<%@ include file="message.jsp" %>

<% }%>
</body>
</html>