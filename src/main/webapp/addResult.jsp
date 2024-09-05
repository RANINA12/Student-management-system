<%@ page import="student.mgmt.entities.Subject" %>
<%@ page import="student.mgmt.entities.Marks" %>
<%@ page import="java.util.List" %>
<%@ page import="student.mgmt.entities.LinkStudentCourse" %>
<%@ page import="student.mgmt.entities.Students" %>
<%@ page import="student.mgmt.dao.StudentDaoImpl" %>
<%@ page import="student.mgmt.dao.StudentDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/addResult.css">
    <title>Add Result</title>
    <style type="text/css">
    body{
    
    background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('image/wallpaperflare.com_wallpaper (12).jpg');
    }
    
    </style>
</head>
<body >
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
        LinkStudentCourse studentCourse = studentDao.fetchCourseDetails1(enrollment_id);
        List<Subject> subjectList = studentDao.getAllSubject1(studentCourse.getCourseCode());
        int count =0;
    %>
    <div class="signup-container">
        <h1>Add Result</h1>
        <form action="addresult" method="get">
           
<label for="EnrollmentID">Enrollment ID:</label>
            <input type="text" id="EnrollmentID" name="EnrollmentID" value="<%= student.getenrollment_id() %>" readonly><br>
            <% for (Subject subject : subjectList) { %>
                <fieldset>
                 
                    
                    <legend class= "box" id="box">Subject: <%= subject.getSubjectName() %></legend>
                    <label for="SubjectName">Subject Name:</label>
                    <input type="text" id="SubjectName" name="SubjectName" value="<%= subject.getSubjectName() %>" ><br>
                    <label for="SubjectCode">SubjectCode:</label>
                    <input type="number" id="SubjectCode" name="SubjectCode" value="<%=subject.getSubjectCode()%>"><br>
                    <label for="Marks<%= subject.getSubjectCode() %>">Marks:</label>
                    <input type="number" id="Marks<%= subject.getSubjectCode() %>" name="Marks" required><br>
                
                </fieldset>
            <% } %>

            <button type="submit">Add Result</button>
        </form>
    </div>
    <%} %>
</body>
</html>
