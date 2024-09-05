package student.mgmt.entities;



public class Course {
	private long CourseCode;
	private String CourseName;
	private String CourseDescription;
	@Override
	public String toString() {
		return "Course [CourseCode=" + CourseCode + ", CourseName=" + CourseName + ", CourseDescription="
				+ CourseDescription + "]";
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
	public String getCourseDescription() {
		return CourseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		CourseDescription = courseDescription;
	}
	public Course(long courseCode, String courseName, String courseDescription) {
		super();
		CourseCode = courseCode;
		CourseName = courseName;
		CourseDescription = courseDescription;
	}
	public Course(String courseName, String courseDescription) {
		super();
		CourseName = courseName;
		CourseDescription = courseDescription;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
}
