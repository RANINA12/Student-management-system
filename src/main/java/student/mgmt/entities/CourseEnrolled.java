package student.mgmt.entities;

import java.sql.Date;

public class CourseEnrolled {
	private long EnrollID;
	private String EnrollmentID;
	private long CourseCode;
	private Date EnrollmentDate;
	public CourseEnrolled() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseEnrolled(String enrollmentID, long courseCode, Date enrollmentDate) {
		super();
		EnrollmentID = enrollmentID;
		CourseCode = courseCode;
		EnrollmentDate = enrollmentDate;
	}
	public CourseEnrolled(long enrollID, String enrollmentID, long courseCode, Date enrollmentDate) {
		super();
		EnrollID = enrollID;
		EnrollmentID = enrollmentID;
		CourseCode = courseCode;
		EnrollmentDate = enrollmentDate;
	}
	public long getEnrollID() {
		return EnrollID;
	}
	public void setEnrollID(long enrollID) {
		EnrollID = enrollID;
	}
	public String getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(String enrollmentID) {
		EnrollmentID = enrollmentID;
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
	@Override
	public String toString() {
		return "CourseEnrolled [EnrollID=" + EnrollID + ", EnrollmentID=" + EnrollmentID + ", CourseCode=" + CourseCode
				+ ", EnrollmentDate=" + EnrollmentDate + "]";
	}
	
}
