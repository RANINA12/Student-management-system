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
import student.mgmt.entities.Subject;

/**
 * Servlet implementation class AddSubjectServlet
 */
@WebServlet("/addsubject")
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String SubjectCode = request.getParameter("SubjectCode");
		String SubjectName= request.getParameter("SubjectName");
		String CourseCode = request.getParameter("CourseCode");
		
		
		System.out.println(SubjectCode);
		System.out.println(SubjectName);
		System.out.println(CourseCode);
		long no = Long.parseLong(SubjectCode);
		long no1 = Long.parseLong(CourseCode);
		
		Subject subject = new Subject(no,SubjectName,no1);
		
		try {
			StudentDao studentDao = new StudentDaoImpl();
			long result= studentDao.addSubject(subject);
			System.out.println(result);
			if(result>0) {
			System.out.println("\n subject added succesfully");
			response.sendRedirect("courseList.jsp?id="+no1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("courseList.jsp?id="+no1);
		}
	}

}
