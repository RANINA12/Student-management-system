package student.mgmt.entities;

import java.sql.Date;

public class Students {
	private String enrollment_id;
	private String name;
	private Date date_Of_birth;
	private String email;
	private long mobile_no;
	private String Address;
	private String gender;
	private String branch;
	public Students(String name, Date date_Of_birth, String email, long mobile_no, String address, String gender,
			String branch) {
		super();
		this.name = name;
		this.date_Of_birth = date_Of_birth;
		this.email = email;
		this.mobile_no = mobile_no;
		this.Address = address;
		this.gender = gender;
		this.branch = branch;
	}
	public Students(String enrollment_id, String name, Date date_Of_birth, String email, long mobile_no, String address,
			String gender, String branch) {
		super();
		this.enrollment_id = enrollment_id;
		this.name = name;
		this.date_Of_birth = date_Of_birth;
		this.email = email;
		this.mobile_no = mobile_no;
		this.Address = address;
		this.gender = gender;
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return "Students [enrollment_id=" + enrollment_id + ", name=" + name + ", date_Of_birth=" + date_Of_birth
				+ ", email=" + email + ", mobile_no=" + mobile_no + ", branch=" + branch + ", Address=" + Address
				+ ", gender=" + gender + "]";
	}
	public String getenrollment_id() {
		return enrollment_id;
	}
	public void setenrollment_id(String enrollment_id) {
		this.enrollment_id = enrollment_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate_Of_birth() {
		return date_Of_birth;
	}
	public void setDate_Of_birth(Date date_Of_birth) {
		this.date_Of_birth = date_Of_birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public Students(String enrollment_id, Date date_Of_birth) {
		super();
		this.enrollment_id = enrollment_id;
		this.date_Of_birth = date_Of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public Students(String enrollment_id, String name, Date dateOfbirth, long mobile_no, String branch) {
		super();
		this.enrollment_id = enrollment_id;
		this.name = name;
		this.date_Of_birth = dateOfbirth;
		this.mobile_no = mobile_no;
		this.branch = branch;
	}
	public Students(String name, Date dateOfbirth, long mobile_no, String branch) {
		super();
		this.name = name;
		this.date_Of_birth = dateOfbirth;
		this.mobile_no = mobile_no;
		this.branch = branch;
	}
	
	
}
