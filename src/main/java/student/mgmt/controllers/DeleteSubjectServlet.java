package student.mgmt.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.mgmt.dao.StudentDao;
import student.mgmt.dao.StudentDaoImpl;

/**
 * Servlet implementation class DeleteSubjectServlet
 */
@WebServlet("/deletesubject")
public class DeleteSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
        String message = "Course can't be deleted. Please try again"; // Fixed the typo here
        try {
            StudentDao studentDao = new StudentDaoImpl();
            long result = studentDao.removeSubject(id);
            if (result > 0) {
                message = "Delete successful"; // Fixed the typo here
                response.sendRedirect("courseList.jsp?message=Delete successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("SubjectList.jsp?message=Delete successful");
        }
       
    }
	}


