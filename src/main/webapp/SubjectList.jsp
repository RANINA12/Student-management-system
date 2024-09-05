<%@page import="student.mgmt.entities.Subject"%>
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
<title>Subject list</title>
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
String code =request.getParameter("id");
long coursecode=Long.parseLong(code);
StudentDao studentDao = new StudentDaoImpl();
List<Subject>subjectList = studentDao.getAllSubject1(coursecode);
%>
<nav id="navbar" class="nav">
    <img src="image/210166517-7f0f3ae2-62bf-4e07-9b7d-4f7c1f5099c8.png" alt="logo" class="logo">
     <a class="logout" href="logout">Logout</a>
  </nav>
  <h1>Subject List</h1>
<table style="margin: auto;">

<tr>
<th>SubjectCode</th>
<th>SubjectName</th>
<th>CourseCode</th>
<th>Action</th>
</tr>


<%for(Subject subject : subjectList ){ %>

<tr>
<td><%= subject.getSubjectCode()%></td>
<td><%= subject.getSubjectName()%></td>
<td><%= subject.getCourseCode()%><br>

</td>
<td>

<a href="deletesubject?id=<%= subject.getSubjectCode()%>" id="red-btn">Delete</a>
</td>

</tr>


<% }%>


<tr>
<td colspan="10" style="text-align:center">
<a class ="blue-btn"href="addSubject.jsp?id=<%=coursecode %>">Add Subject</a>
</td>
</tr>
</table>
<%@ include file="message.jsp" %>
<%} %>

</body>
</html>