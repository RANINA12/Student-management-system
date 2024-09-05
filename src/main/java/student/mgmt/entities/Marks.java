package student.mgmt.entities;

public class Marks {
	private long SubjectCode;
	private String SubjectName;
private long Mark;
private String EnrollmentID;

public Marks(long subjectCode, String subjectName, long mark) {
	super();
	SubjectCode = subjectCode;
	SubjectName = subjectName;
	Mark = mark;
}
public Marks() {
	super();
	// TODO Auto-generated constructor stub
}
public Marks(long subjectCode, String subjectName, long marks, String enrollmentID) {
	super();
	SubjectCode = subjectCode;
	SubjectName = subjectName;
	Mark = marks;
	EnrollmentID = enrollmentID;
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
public long getMarks() {
	return Mark;
}
public void setMarks(long marks) {
	Mark = marks;
}
public String getEnrollmentID() {
	return EnrollmentID;
}
public void setEnrollmentID(String enrollmentID) {
	EnrollmentID = enrollmentID;
}
@Override
public String toString() {
	return "Marks [SubjectCode=" + SubjectCode + ", SubjectName=" + SubjectName + ", Marks=" + Mark + ", EnrollmentID="
			+ EnrollmentID + "]";
}

}