package student.mgmt.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.mgmt.dao.StudentDaoImpl;
import student.mgmt.entities.Students;
import student.mgmt.dao.StudentDao;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/logIn")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enrollment_id = request.getParameter("userID");
		String date_Of_birth = request.getParameter("date_of_birth");
		System.out.println(enrollment_id);
		try {
	        java.sql.Date dob = java.sql.Date.valueOf(date_Of_birth);
	        System.out.println(date_Of_birth);
	        

	        StudentDao studentDao = new StudentDaoImpl();

	         
	        Students student= studentDao.fetchStudentDetails(enrollment_id, dob);
	        	if(student!=null) {
	    			System.out.println("\n Login succesfully");
	    			HttpSession session = request.getSession();
					session.setAttribute("username", enrollment_id);
					session.setAttribute("password", dob);
	    			response.sendRedirect("studentinfo.jsp?id="+enrollment_id);
	
	    			
	    			}else {
	    				response.sendRedirect("login.jsp?message=account not exist or invelid password");
	    			}
}catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("login.jsp?message=Something went wrong");
	    }
	}}
