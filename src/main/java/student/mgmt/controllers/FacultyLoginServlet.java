package student.mgmt.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.mgmt.dao.StudentDao;
import student.mgmt.dao.StudentDaoImpl;
import student.mgmt.entities.Faculty;

/**
 * Servlet implementation class FacultyLoginServlet
 */
@WebServlet("/facultylogin")
public class FacultyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("userID");

		System.out.println(name);
		System.out.println(code);

		try {
		Long computerCode = Long.parseLong(code);

		
			StudentDao studentDao = new StudentDaoImpl();

			Faculty faculty = studentDao.fetchFacultyDetails(name, computerCode);
			
			if (faculty != null) {

				System.out.println("\n Login succesfully");
				HttpSession session = request.getSession();
				
				session.setAttribute("username", name);
				session.setAttribute("password", code);
				response.sendRedirect("Editor.jsp?id="+computerCode+"&userName="+name);

			} else {
				response.sendRedirect("facultyLogin.jsp?message=account not exist or invelid information");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
			response.sendRedirect("facultyLogin.jsp?message=Something went wrong please try again");
		}

	}

}
