package student.mgmt.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.mgmt.dao.StudentDao;
import student.mgmt.dao.StudentDaoImpl;
import student.mgmt.entities.Students;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enrollment_id = request.getParameter("enrollment_id");
		String name = request.getParameter("name");
		String date_Of_birth = request.getParameter("date_Of_birth");
		String Email = request.getParameter("email");
		String mobile_no = request.getParameter("mobile_no");
		String address = request.getParameter("Address");
		String gender = request.getParameter("gender");
		String branch = request.getParameter("Branch");
		java.sql.Date dob = java.sql.Date.valueOf(date_Of_birth);
Long no = Long.parseLong(mobile_no);

		Students student = new Students(enrollment_id, name, dob, Email, no, address, gender, branch);
		
		try {
			StudentDao studentDao = new StudentDaoImpl();
			int result = studentDao.modifyStudent(student);
			
			if (result > 0) {
				System.out.println("\n Student updated successfully");
				response.sendRedirect("studentsList.jsp?message=Student updated Successfully");
			} else {
				response.sendRedirect("updateStudent.jsp?message=Student not updated Successfully");
				System.out.println("failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("updateStudent.jsp?message=Employee not updated Successfully");
			e.printStackTrace();
		}
		
	}

}
