package student.mgmt.dao;

import java.sql.Date;
import java.util.List;



import student.mgmt.entities.Course;
import student.mgmt.entities.CourseEnrolled;
import student.mgmt.entities.Faculty;
import student.mgmt.entities.LinkStudentCourse;
import student.mgmt.entities.Marks;
import student.mgmt.entities.Result;
import student.mgmt.entities.Students;
import student.mgmt.entities.Subject;

public interface StudentDao {
	void createSchema() throws Exception;
	void createTable() throws Exception;
	int addStudent(Students student) throws Exception;
	int modifyStudent(Students student)throws Exception;
	int removeStudent(String enrollment_id) throws Exception;
	List<Students> getAllStudents() throws Exception;
	Students fetchStudentDetails(String enrollment_id, Date dob) throws Exception;
	Students fetchStudentDetails1(String enrollment_id) throws Exception;
	Faculty fetchFacultyDetails(String name, long computerCode) throws Exception;
	List<Course> getAllCourses() throws Exception;
	LinkStudentCourse fetchCourseDetails1(String id) throws Exception;
	CourseEnrolled fetchCourseDetails(String enrollment_id) throws Exception;
	int addCourse(Course course) throws Exception;
	long removeCourse(String id) throws Exception;
	List<Subject> getAllSubject() throws Exception;
	long removeSubject(String id) throws Exception;
	long addSubject(Subject subject) throws Exception;
	int addcourseenroll(CourseEnrolled courseenroll) throws Exception;
	List<Subject> getAllSubject1(long courseCode) throws Exception;
	List<Marks> getResult(String enrollment_id) throws Exception;
	int addMarks(Marks marks) throws Exception;
}
