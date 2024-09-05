package student.mgmt.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.mgmt.dao.StudentDao;
import student.mgmt.dao.StudentDaoImpl;
import student.mgmt.entities.CourseEnrolled;

/**
 * Servlet implementation class EnrollStudentServlet
 */
@WebServlet("/enrollstudent")
public class EnrollStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String EnrollmentID = request.getParameter("EnrollmentID");
		String coursecode = request.getParameter("CourseCode");
		String enrollmentdate = request.getParameter("EnrollmentDate");
		
		
		 Long CourseCode = Long.parseLong(coursecode);
		 Date EnrollmentDate = Date.valueOf(enrollmentdate);
		
		 
		System.out.println(EnrollmentID);
		System.out.println(CourseCode);
		System.out.println(EnrollmentDate);

		
		CourseEnrolled courseenroll = new CourseEnrolled(EnrollmentID,CourseCode,EnrollmentDate);
		try {
			System.out.println("chack");
			StudentDao studentDao = new StudentDaoImpl();
			int result= studentDao.addcourseenroll(courseenroll);
			System.out.println("chack");
			if(result>0) {
			System.out.println("\n course added succesfully");
			response.sendRedirect("studentsList.jsp?message=Course registered Successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
