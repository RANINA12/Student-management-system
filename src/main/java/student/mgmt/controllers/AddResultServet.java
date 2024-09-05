package student.mgmt.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.mgmt.dao.StudentDao;
import student.mgmt.dao.StudentDaoImpl;
import student.mgmt.entities.Marks;
/**
 * Servlet implementation class AddResultServet
 */
@WebServlet("/addresult")
public class AddResultServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String EnrollmentID = request.getParameter("EnrollmentID");
		String[] subjectNames = request.getParameterValues("SubjectName");
		String[] subjectCodes = request.getParameterValues("SubjectCode");
		String[] marks = request.getParameterValues("Marks");
		
		for (int i = 0; i < subjectNames.length; i++) {
			String SubjectName = subjectNames[i];
			long SubjectCode = Long.parseLong(subjectCodes[i]);
			long Marks = Long.parseLong(marks[i]);
			Marks marksEntity = new Marks(SubjectCode, SubjectName, Marks, EnrollmentID);
			System.out.println(marksEntity);
			try {
				StudentDao studentDao = new StudentDaoImpl();
				long result = studentDao.addMarks(marksEntity);
				System.out.println(result);
				if (result > 0) {
					System.out.println("\n Marks added succesfully");
					response.sendRedirect("courseEnrolled.jsp?id="+EnrollmentID);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}
}