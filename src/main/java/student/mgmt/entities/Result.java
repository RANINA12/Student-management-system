package student.mgmt.entities;

import java.sql.Date;

public class Result {
	private String EnrollmentID;
	private String StudentName;
	private Date DateOfBirth;
	private String Email;
	private long MobileNo;
	private String Address;
	private String Gender;
	private String Branch;
	private long CourseCode;
	private String CourseName;
	private Date EnrollmentDate;
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result(String studentName, Date dateOfBirth, String email, long mobileNo, String address, String gender,
			String branch, long courseCode, String courseName, Date enrollmentDate) {
		super();
		StudentName = studentName;
		DateOfBirth = dateOfBirth;
		Email = email;
		MobileNo = mobileNo;
		Address = address;
		Gender = gender;
		Branch = branch;
		CourseCode = courseCode;
		CourseName = courseName;
		EnrollmentDate = enrollmentDate;
	}
	public Result(String enrollmentID, String studentName, Date dateOfBirth, String email, long mobileNo,
			String address, String gender, String branch, long courseCode, String courseName, Date enrollmentDate) {
		super();
		EnrollmentID = enrollmentID;
		StudentName = studentName;
		DateOfBirth = dateOfBirth;
		Email = email;
		MobileNo = mobileNo;
		Address = address;
		Gender = gender;
		Branch = branch;
		CourseCode = courseCode;
		CourseName = courseName;
		EnrollmentDate = enrollmentDate;
	}
	public String getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(String enrollmentID) {
		EnrollmentID = enrollmentID;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(long mobileNo) {
		MobileNo = mobileNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public long getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(long courseCode) {
		CourseCode = courseCode;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public Date getEnrollmentDate() {
		return EnrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		EnrollmentDate = enrollmentDate;
	}
	@Override
	public String toString() {
		return "Result [EnrollmentID=" + EnrollmentID + ", StudentName=" + StudentName + ", DateOfBirth=" + DateOfBirth
				+ ", Email=" + Email + ", MobileNo=" + MobileNo + ", Address=" + Address + ", Gender=" + Gender
				+ ", Branch=" + Branch + ", CourseCode=" + CourseCode + ", CourseName=" + CourseName
				+ ", EnrollmentDate=" + EnrollmentDate + "]";
	}
	
}