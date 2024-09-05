package student.mgmt.utils;

public class DbUtils {
public static final String DRIVER ="com.mysql.cj.jdbc.Driver";
public static final String DB_BASE = "jdbc:mysql://localhost:3306";
public static final String DB_URL ="jdbc:mysql://localhost:3306/institute";
public static final String USERNAME ="root";
public static final String PASSWORD ="1234";

public static final String CREATE_SCHEMA="Create schema institute";
public static final String CREATE_TABLE ="CREATE TABLE StudentRecords (\r\n"
		+ "    EnrollmentID VARCHAR(50) NOT NULL PRIMARY KEY,\r\n"
		+ "    Name VARCHAR(100) NOT NULL,\r\n"
		+ "    DateOfBirth DATE NOT NULL,\r\n"
		+ "    Email VARCHAR(100),\r\n"
		+ "    MobileNo BIGINT,\r\n"
		+ "    Branch VARCHAR(50) NOT NULL,\r\n"
		+ "    Address VARCHAR(255),\r\n"
		+ "    Gender CHAR(1) NOT NULL,\r\n"
		+ "    Year INT NOT NULL\r\n"
		+ ");\r\n"
		+ "\r\n"
		+ "CREATE TABLE CourseEnrollment (\r\n"
		+ "    EnrollID INT PRIMARY KEY,\r\n"
		+ "    EnrollmentID VARCHAR(50) NOT NULL PRIMARY KEY,\r\n"
		+ "    CourseCode VARCHAR(10),\r\n"
		+ "    EnrollmentDate DATE\r\n"
		+ ");\r\n"
		+ "\r\n"
		+ "CREATE TABLE GradeManagement (\r\n"
		+ "    GradeID INT PRIMARY KEY,\r\n"
		+ "    EnrollmentID VARCHAR(50) NOT NULL PRIMARY KEY,\r\n"
		+ "    CourseCode VARCHAR(10),\r\n"
		+ "    Grade CHAR(2)\r\n"
		+ ");\r\n"
		+ "";

public static final String INSERT_STUDENT = "INSERT INTO studentrecords (EnrollmentID,Name,DateOfBirth,Email,MobileNo,Address,Gender,Branch ) VALUES (?,?,?,?,?,?,?,?)";
public static final String UPDATE_STUDENT=" UPDATE studentrecords SET EnrollmentID = ?,Name = ?,DateOfBirth = ?,Email = ?,MobileNo = ?,Address = ?,Gender = ?,Branch = ? WHERE EnrollmentID = ?";
public static final String DELETE_STUDENT="DELETE FROM studentrecords WHERE EnrollmentID = ?";
public static final String GET_ONE_STUDENT="SELECT * FROM studentrecords WHERE EnrollmentID = ? AND DateOfBirth = ?";
public static final String GET_ONE_STUDENT1="SELECT * FROM studentrecords WHERE EnrollmentID = ?";
public static final String GET_ALL_STUDENT ="SELECT * FROM studentrecords";
public static final String GET_ONE_FACULTY="SELECT * FROM faculty WHERE computerCode= ? AND name = ?";
public static final String GET_ALL_COURSE ="SELECT * FROM courses";
public static final String INSERT_COURSE="INSERT INTO courses (CourseCode, CourseName, CourseDescription) VALUES (?,?,?)";
public static final String DELETE_COURSE="DELETE FROM courses WHERE CourseCode = ?";
public static final String GET_ONE_COURSE="SELECT enrol.EnrollmentID, c.CourseName, enrol.CourseCode, enrol.EnrollmentDate, c.CourseDescription \r\n"
		+ "   FROM courseenrollment AS enrol \r\n"
		+ "   INNER JOIN courses AS c ON enrol.CourseCode = c.CourseCode \r\n"
		+ "   WHERE enrol.EnrollmentID = ?";
public static final String GET_ALL_SUBJECT="SELECT * FROM subjects";
public static final String GET_LINK_SUBJECT="SELECT * FROM subjects\r\n"
		+ "where CourseCode = ?";
public static final String DELETE_SUBJECT="DELETE FROM subjects WHERE SubjectCode = ?";
public static final String INSERT_SUBJECT="INSERT INTO subjects (SubjectCode, SubjectName, CourseCode) VALUES (?,?,?)";
public static final String GET_COURSE_ENROLL="SELECT * FROM courseenrollment WHERE EnrollmentID = ?";
public static final String ENROLLSTUDENT="INSERT INTO  courseenrollment ( EnrollmentID, CourseCode, EnrollmentDate) VALUES (?,?,?)";
public static final String GET_RESULT= "SELECT * FROM subjectmarks WHERE EnrollmentID = ?";
public static final String INSERT_MARKS="INSERT INTO subjectmarks (SubjectCode, SubjectName, Marks,EnrollmentID) VALUES (?,?,?,?)";
}
