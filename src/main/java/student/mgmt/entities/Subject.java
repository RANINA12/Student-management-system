package student.mgmt.entities;


public class Subject {
	private long SubjectCode;
	private String SubjectName;
	private long CourseCode;
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(long subjectCode, String subjectName, long courseCode) {
		super();
		SubjectCode = subjectCode;
		SubjectName = subjectName;
		CourseCode = courseCode;
	}
	public Subject(String subjectName, long courseCode) {
		super();
		SubjectName = subjectName;
		CourseCode = courseCode;
	}
	public long getSubjectCode() {
		return SubjectCode;
	}
	public void setSubjectCode(long subjectCode) {
		SubjectCode = subjectCode;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	public long getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(long courseCode) {
		CourseCode = courseCode;
	}
	@Override
	public String toString() {
		return "Subject [SubjectCode=" + SubjectCode + ", SubjectName=" + SubjectName + ", CourseCode=" + CourseCode
				+ "]";
	}
	
}