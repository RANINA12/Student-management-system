<%@ page import="student.mgmt.entities.*" %>
<%@ page import="java.util.List" %>
<%@ page import="student.mgmt.dao.StudentDaoImpl" %>
<%@ page import="student.mgmt.dao.StudentDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Report Card</title>
    <link rel="stylesheet" href="css/result.css">
</head>
<body>
	<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
String username = (String)session.getAttribute("username");


if(username==null) {
	response.sendRedirect("facultyLogin.jsp");
}else{%>
    <%
    String enrollment_id = request.getParameter("id");
    if (enrollment_id != null && !enrollment_id.isEmpty()) {
        StudentDao studentDao = new StudentDaoImpl();
        Students student = studentDao.fetchStudentDetails1(enrollment_id);
        LinkStudentCourse studentCourse = studentDao.fetchCourseDetails1(enrollment_id);
        List<Marks> resultList = studentDao.getResult(enrollment_id);
        boolean isFailed = false;
    %>

    <header class="header">
        <h1>Examination Result</h1>
    </header>

    <section class="student-details">
        <ul>
            <li><span>Enrollment ID:</span> <%= student.getenrollment_id() %></li>
            <li><span>Name:</span> <%= student.getName() %></li>
            <li><span>Date of Birth:</span> <%= student.getDate_Of_birth() %></li>
            <li><span>Email:</span> <%= student.getEmail() %></li>
            <li><span>Mobile No:</span> <%= student.getMobile_no() %></li>
            <li><span>Address:</span> <%= student.getAddress() %></li>
            <li><span>Gender:</span> <%= student.getGender() %></li>
            <li><span>Branch:</span> <%= student.getBranch() %></li>
            <li><span>Course Code:</span> <%= studentCourse.getCourseCode() %></li>
            <li><span>Course Name:</span> <%= studentCourse.getCourseName() %></li>
            <li><span>Enrollment Date:</span> <%= studentCourse.getEnrollmentDate() %></li>
        </ul>
    </section>

    <% if (resultList != null && !resultList.isEmpty()) { %>
    <section class="subject-details">

        <table class="table">
            <thead>
                <tr>
                    <th>Subject Code</th>
                    <th>Subject Name</th>
                    <th>Mark</th>
                    <th>Grade</th>
                </tr>
            </thead>
            <tbody>
                <% 
                for (Marks result : resultList) { 
                    String grade;
                    long marks = result.getMarks();
                    if (marks >= 90) {
                        grade = "A";
                    } else if (marks >= 80) {
                        grade = "B";
                    } else if (marks >= 70) {
                        grade = "C";
                    } else if (marks >= 60) {
                        grade = "D";
                    } else {
                        grade = "F";
                       isFailed = true;
                    }
                %>
                <tr>
                    <td><%= result.getSubjectCode() %></td>
                    <td><%= result.getSubjectName() %></td>
                    <td><%= marks %></td>
                    <td><%= grade %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </section>

   <section class="result">
    <h2 class="section-title">Result</h2>
    <% if (isFailed) { %>
        <p>Fail</p>
    <% } else { %>
        <p>Pass</p>
    <% } %>
</section>
    <% } else { %>
    <h1>Result not yet declared</h1>
    <% } %>
    
    <% } else { %>
    <h1>Invalid Enrollment ID</h1>
    <% }%>
    <% }%>
</body>
</html>
