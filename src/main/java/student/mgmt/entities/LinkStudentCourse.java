package student.mgmt.entities;

import java.sql.Date;

public class LinkStudentCourse {
	private String EnrollmentID;
	private String CourseName;
	private String CourseDescription;
	private long CourseCode;
	private Date EnrollmentDate;
	@Override
	public String toString() {
		return "LinkStudentCourse [EnrollmentID=" + EnrollmentID + ", CourseName=" + CourseName + ", CourseDescription="
				+ CourseDescription + ", CourseCode=" + CourseCode + ", EnrollmentDate=" + EnrollmentDate + "]";
	}
	public String getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(String enrollmentID) {
		EnrollmentID = enrollmentID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getCourseDescription() {
		return CourseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		CourseDescription = courseDescription;
	}
	public long getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(long courseCode) {
		CourseCode = courseCode;
	}
	public Date getEnrollmentDate() {
		return EnrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		EnrollmentDate = enrollmentDate;
	}
	public LinkStudentCourse(String enrollmentID, String courseName, String courseDescription, long courseCode,
			Date enrollmentDate) {
		super();
		EnrollmentID = enrollmentID;
		CourseName = courseName;
		CourseDescription = courseDescription;
		CourseCode = courseCode;
		EnrollmentDate = enrollmentDate;
	}
	public LinkStudentCourse(String courseName, String courseDescription, long courseCode, Date enrollmentDate) {
		super();
		CourseName = courseName;
		CourseDescription = courseDescription;
		CourseCode = courseCode;
		EnrollmentDate = enrollmentDate;
	}
	public LinkStudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
