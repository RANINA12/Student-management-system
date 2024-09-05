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


@WebServlet("/signup")
public class SingupServlet extends HttpServlet {
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
		
		
		System.out.println(enrollment_id);
		System.out.println(name);
		System.out.println(Email);
		System.out.println(mobile_no);
		System.out.println(address);
		System.out.println(date_Of_birth);
		System.out.println(gender);
		System.out.println(branch);
		java.sql.Date dob = java.sql.Date.valueOf(date_Of_birth);
		long no = Long.parseLong(mobile_no);

		
		Students student = new Students(enrollment_id,name, dob,Email, no, address,gender,branch);
		try {
			StudentDao studentDao = new StudentDaoImpl();
			int result= studentDao.addStudent(student);
			if(result>0) {
			System.out.println("\n student added succesfully");
			response.sendRedirect("studentsList.jsp?message=Student registered Successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}





	}
