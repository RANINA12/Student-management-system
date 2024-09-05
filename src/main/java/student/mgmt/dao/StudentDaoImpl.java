package student.mgmt.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import student.mgmt.entities.Students;
import student.mgmt.entities.Subject;
import student.mgmt.entities.Course;
import student.mgmt.entities.CourseEnrolled;
import student.mgmt.entities.Faculty;
import student.mgmt.entities.LinkStudentCourse;
import student.mgmt.entities.Marks;

import student.mgmt.utils.DbUtils;

public class StudentDaoImpl implements StudentDao {

	public Connection getConnection() throws Exception {
		Class.forName(DbUtils.DRIVER);

		Connection con = DriverManager.getConnection(DbUtils.DB_URL, DbUtils.USERNAME, DbUtils.PASSWORD);
		return con;
	}

	@Override
	public void createSchema() throws Exception {
		Class.forName(DbUtils.DRIVER);

		Connection con = DriverManager.getConnection(DbUtils.DB_BASE, DbUtils.USERNAME, DbUtils.PASSWORD);
		Statement stmt = con.createStatement();
		stmt.executeUpdate(DbUtils.CREATE_SCHEMA);

	}

	@Override
	public void createTable() throws Exception {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(DbUtils.CREATE_TABLE);

	}

	@Override
	public int addStudent(Students student) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.INSERT_STUDENT);
		pStmt.setString(1, student.getenrollment_id());
		pStmt.setString(2, student.getName());
		pStmt.setDate(3, student.getDate_Of_birth());
		pStmt.setString(4, student.getEmail());
		pStmt.setLong(5, student.getMobile_no());
		pStmt.setString(6, student.getAddress());
		pStmt.setString(7, student.getGender());
		pStmt.setString(8, student.getBranch());

		int result = pStmt.executeUpdate();
		return result;
	}

	@Override
	public int modifyStudent(Students student) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.UPDATE_STUDENT);
		pStmt.setString(1, student.getenrollment_id());
		pStmt.setString(2, student.getName());
		pStmt.setDate(3, student.getDate_Of_birth());
		pStmt.setString(4, student.getEmail());
		pStmt.setLong(5, student.getMobile_no());
		pStmt.setString(6, student.getAddress());
		pStmt.setString(7, student.getGender());
		pStmt.setString(8, student.getBranch());
		pStmt.setString(9, student.getenrollment_id());
		return pStmt.executeUpdate();
	}

	@Override
	public int removeStudent(String enrollment_id) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.DELETE_STUDENT);
		pStmt.setString(1, enrollment_id);
		return pStmt.executeUpdate();
	}

	@Override
	public Students fetchStudentDetails(String enrollment_id, Date date_Of_birth) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.GET_ONE_STUDENT);
		pStmt.setString(1, enrollment_id);
		pStmt.setDate(2, date_Of_birth);
		ResultSet rSet = pStmt.executeQuery();
		Students student = null;
		if (rSet.next()) {

			String id = rSet.getString("EnrollmentID");
			String name = rSet.getString("name");
			Date dob = rSet.getDate("DateOfbirth");
			String email = rSet.getString("Email");
			Long no = rSet.getLong("MobileNo");
			String address = rSet.getString("Address");
			String gender = rSet.getString("Gender");
			String branch = rSet.getString("Branch");
			student = new Students(id, name, dob, email, no, address, gender, branch);

		}

		return student;
	}

	@Override
	public Students fetchStudentDetails1(String enrollment_id) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.GET_ONE_STUDENT1);
		pStmt.setString(1, enrollment_id);

		ResultSet rSet = pStmt.executeQuery();
		Students student = null;
		if (rSet.next()) {
			String id = rSet.getString("EnrollmentID");
			String name = rSet.getString("name");
			Date dob = rSet.getDate("DateOfbirth");
			String email = rSet.getString("Email");
			Long no = rSet.getLong("MobileNo");
			String address = rSet.getString("Address");
			String gender = rSet.getString("Gender");
			String branch = rSet.getString("Branch");
			student = new Students(id, name, dob, email, no, address, gender, branch);

		}
		return student;
	}

	@Override
	public List<Students> getAllStudents() throws Exception {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery(DbUtils.GET_ALL_STUDENT);
		List<Students> student = new ArrayList<Students>();
		while (rSet.next()) {
			String id = rSet.getString("EnrollmentID");
			String name = rSet.getString("Name");
			Date dob = rSet.getDate("DateOfBirth");
			String email = rSet.getString("Email");
			Long no = rSet.getLong("MobileNo");
			String address = rSet.getString("Address");
			String gender = rSet.getString("Gender");
			String branch = rSet.getString("Branch");
			student.add(new Students(id, name, dob, email, no, address, gender, branch));

		}
		return student;
	}

	@Override
	public Faculty fetchFacultyDetails(String Name, long computerCode) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.GET_ONE_FACULTY);
		pStmt.setLong(1, computerCode);
		pStmt.setString(2, Name);

		ResultSet rSet = pStmt.executeQuery();
		Faculty faculty = null;

		if (rSet.next()) {

			System.out.println("data present");

			String code = rSet.getString("computerCode");
			String name = rSet.getString("name");
			Date dob = rSet.getDate("date_Of_birth");
			String email = rSet.getString("Email");
			Long no = rSet.getLong("mobile_no");
			String address = rSet.getString("Address");
			String gender = rSet.getString("Gender");
			String branch = rSet.getString("Branch");
			Long id = Long.parseLong(code);

			faculty = new Faculty(id, name, dob, email, no, address, gender, branch);

		}
		return faculty;
	}

	@Override
	public List<Course> getAllCourses() throws Exception {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery(DbUtils.GET_ALL_COURSE);
		List<Course> course = new ArrayList<Course>();
		while (rSet.next()) {
			String courseCode = rSet.getString("courseCode");
			String name = rSet.getString("courseName");
			String Description = rSet.getString("CourseDescription");
			Long id = Long.parseLong(courseCode);
			course.add(new Course(id, name, Description));

		}
		return course;
	}

	@Override
	public int addCourse(Course course) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.INSERT_COURSE);
		pStmt.setLong(1, course.getCourseCode());
		pStmt.setString(2, course.getCourseName());
		pStmt.setString(3, course.getCourseDescription());

		int result = pStmt.executeUpdate();
		return result;
	}

	@Override
	public long removeCourse(String id) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.DELETE_COURSE);
		pStmt.setString(1, id);
		return pStmt.executeUpdate();
	}

	@Override
	public List<Subject> getAllSubject() throws Exception {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery(DbUtils.GET_ALL_SUBJECT);
		List<Subject> subject = new ArrayList<Subject>();
		while (rSet.next()) {
			String SubjectCode = rSet.getString("SubjectCode");
			String SubjectName = rSet.getString("SubjectName");
			String CourseCode = rSet.getString("CourseCode");
			long id1 = Long.parseLong(SubjectCode);
			long id = Long.parseLong(CourseCode);
			subject.add(new Subject(id1, SubjectName, id));
		}
		return subject;
	}

	@Override
	public long removeSubject(String id) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.DELETE_SUBJECT);
		pStmt.setString(1, id);
		return pStmt.executeUpdate();
	}

	@Override
	public long addSubject(Subject subject) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.INSERT_SUBJECT);
		pStmt.setLong(1, subject.getSubjectCode());
		pStmt.setString(2, subject.getSubjectName());
		pStmt.setLong(3, subject.getCourseCode());

		int result = pStmt.executeUpdate();
		return result;
	}

	@Override
	public CourseEnrolled fetchCourseDetails(String enrollment_id) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.GET_COURSE_ENROLL);
		pStmt.setString(1, enrollment_id);

		ResultSet rSet = pStmt.executeQuery();
		CourseEnrolled courseEnroll = null;

		if (rSet.next()) {

			System.out.println("data present");

			String enrollid = rSet.getString("EnrollID");
			String EnrollmentID = rSet.getString("EnrollmentID");
			String coursecode = rSet.getString("CourseCode");
			String EnrollmentDate = rSet.getString("EnrollmentDate");
			Long EnrollID = Long.parseLong(enrollid);
			Long CourseCode = Long.parseLong(coursecode);
			Date enrollmentdate = Date.valueOf(EnrollmentDate);
			courseEnroll = new CourseEnrolled(EnrollID, EnrollmentID, CourseCode, enrollmentdate);

		} else {
			System.out.println("data not present");
		}
		return courseEnroll;
	}

	@Override
	public int addcourseenroll(CourseEnrolled courseenroll) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.ENROLLSTUDENT);

		System.out.println(courseenroll);

	
		pStmt.setString(1, courseenroll.getEnrollmentID());
		pStmt.setLong(2, courseenroll.getCourseCode());
		pStmt.setDate(3, courseenroll.getEnrollmentDate());
		int result = pStmt.executeUpdate();
		return result;
	}

	@Override
	public LinkStudentCourse fetchCourseDetails1(String enrollment_id) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(DbUtils.GET_ONE_COURSE);
		pStmt.setString(1, enrollment_id);
		ResultSet rSet = pStmt.executeQuery();
		LinkStudentCourse studentCourse = null;
		if (rSet.next()) {
			
			String EnrollmentID = rSet.getString("EnrollmentID");
			String name = rSet.getString("CourseName");
			String Description = rSet.getString("CourseDescription");
			String id = rSet.getString("courseCode");
			String date = rSet.getString("EnrollmentDate");
			
			long CourseCode = Long.parseLong(id);
			Date EnrollmentDate=Date.valueOf(date);
			
			
			studentCourse = new LinkStudentCourse(EnrollmentID, name, Description, CourseCode, EnrollmentDate);

		}
		return studentCourse;
	}
	@Override
	public List<Subject> getAllSubject1(long coursecode) throws Exception {
	    Connection con = getConnection();
	    PreparedStatement pStmt = con.prepareStatement(DbUtils.GET_LINK_SUBJECT);
	    pStmt.setLong(1, coursecode);
	    ResultSet rSet = pStmt.executeQuery();

	    List<Subject> subjectList = new ArrayList<>();
	    while (rSet.next()) {
	        String subjectCode = rSet.getString("SubjectCode");
	        String subjectName = rSet.getString("SubjectName");
	        String courseCode = rSet.getString("CourseCode");

	        long id1 = Long.parseLong(subjectCode);
	        long id = Long.parseLong(courseCode);

	        subjectList.add(new Subject(id1, subjectName, id));
	    }

	    return subjectList;
	}
	

	@Override
	public List<Marks> getResult(String enrollment_id) throws Exception {
	    Connection con = getConnection();
	    PreparedStatement pStmt = con.prepareStatement(DbUtils.GET_RESULT);
	    pStmt.setString(1, enrollment_id);
	    ResultSet rSet = pStmt.executeQuery();

	    List<Marks> marksList = new ArrayList<>();
	    while (rSet.next()) {
	        String subjectCode = rSet.getString("SubjectCode");
	        String subjectName = rSet.getString("SubjectName");
	        String Mark = rSet.getString("Marks");

	        long id1 = Long.parseLong(subjectCode);
	        long id = Long.parseLong(Mark);

	        marksList.add(new Marks(id1, subjectName, id, enrollment_id));
	    }

	    return marksList;
	}

	@Override
	public int addMarks(Marks marks) throws Exception {
	    Connection con = getConnection();
	    PreparedStatement pStmt = con.prepareStatement(DbUtils.INSERT_MARKS);

	    pStmt.setLong(1, marks.getSubjectCode());
	    pStmt.setString(2, marks.getSubjectName());
	    pStmt.setLong(3, marks.getMarks());
	    pStmt.setString(4, marks.getEnrollmentID());
	    
	    int result = pStmt.executeUpdate();
	    return result;
	}

	}
