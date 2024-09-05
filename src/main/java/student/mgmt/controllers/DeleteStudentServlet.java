package student.mgmt.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.mgmt.dao.StudentDao;
import student.mgmt.dao.StudentDaoImpl;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String message = "Student can't be deleted. Please try again"; // Fixed the typo here
        try {
            StudentDao studentDao = new StudentDaoImpl();
            int result = studentDao.removeStudent(id);
            if (result > 0) {
                message = "Delete successful"; // Fixed the typo here
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("studentsList.jsp?message=" + message);
    }
}