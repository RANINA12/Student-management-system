package student.mgmt.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.mgmt.dao.StudentDao;
import student.mgmt.dao.StudentDaoImpl;
import student.mgmt.entities.Course;

/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/addcourse")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CourseCode = request.getParameter("CourseCode");
		String CourseName= request.getParameter("CourseName");
		String CourseDescription = request.getParameter("CourseDescription");
		
		
		System.out.println(CourseCode);
		System.out.println(CourseName);
		System.out.println(CourseDescription);
		long no = Long.parseLong(CourseCode);

		
		Course course = new Course(no,CourseName,CourseDescription);
		try {
			StudentDao studentDao = new StudentDaoImpl();
			int result= studentDao.addCourse(course);
			if(result>0) {
			System.out.println("\n course added succesfully");
			response.sendRedirect("courseList.jsp?message=Course registered Successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("courseList.jsp?message=something went wrong");
		}
		
		
	}

}
