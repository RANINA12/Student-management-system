<%@page import="student.mgmt.entities.Subject"%>
<%@page import="student.mgmt.entities.LinkStudentCourse"%>
<%@page import="student.mgmt.entities.CourseEnrolled"%>
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
<title>Course Enrollment</title>
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
	
	<% String enrollment_id = request.getParameter("id");
	StudentDao studentDao = new StudentDaoImpl();
	LinkStudentCourse StudentCourse = studentDao.fetchCourseDetails1(enrollment_id);
	%>
	<%
		if (StudentCourse != null) {
		%>
	<%
	long coursecode = StudentCourse.getCourseCode();
	StudentDao studentDao1 = new StudentDaoImpl();
	List<Subject> subjectList = studentDao1.getAllSubject1(coursecode);
	%>
	<nav id="navbar" class="nav">
    <img src="image/210166517-7f0f3ae2-62bf-4e07-9b7d-4f7c1f5099c8.png" alt="logo" class="logo">
         <a class="logout" href="logout">Logout</a>
  </nav>
	<div>
		<h1 class="mb-0">Course Enrolled</h1>

		<table class="" style="">


			<tr>
				<th>Enrollment Id:-</th>

				<td><%=StudentCourse.getEnrollmentID()%></td>
			</tr>

			<tr>
				<th>CourseCode:-</th>

				<td><%=StudentCourse.getCourseCode()%></td>
			</tr>

			<tr>
				<th>Date of Enroll</th>

				<td><%=StudentCourse.getEnrollmentDate()%></td>
			<tr>
				<th>Course:-</th>

				<td><%=StudentCourse.getCourseName()%></td>
			</tr>
		</table>
		<h1> Subject List</h1>
		<table style="margin: auto;">
			
			<tr>
				<th>SubjectCode</th>
				<th>SubjectName</th>
				<th>CourseCode</th>
				
			</tr>


			<%
			for (Subject subject : subjectList) {
			%>

			<tr>
				<td><%=subject.getSubjectCode()%></td>
				<td><%=subject.getSubjectName()%></td>
				<td><%=subject.getCourseCode()%><br></td>
			

			</tr>


			<%
			}
			%>


			<tr>
				<td colspan="10" style="text-align: center"><a class="blue-btn"
					href="result.jsp?id=<%=StudentCourse.getEnrollmentID()%>">Show Result</a></td>
			</tr>
		</table>
		<%
		} else {
		%>
		<nav id="navbar" class="nav">
    <img src="image/210166517-7f0f3ae2-62bf-4e07-9b7d-4f7c1f5099c8.png" alt="logo" class="logo">
     <a class="logout" href="logout">Logout</a>
  </nav>
		<h1>This student is not yet enrolled in any course.</h1>
		<a class="blue-btn" href="EnrollInCourse.jsp?id=<%=enrollment_id%>">Enroll in Course</a>
		<%
		}
		%>
	</div>
	<%@ include file="message.jsp"%>

<%}	%>
</body>
</html>